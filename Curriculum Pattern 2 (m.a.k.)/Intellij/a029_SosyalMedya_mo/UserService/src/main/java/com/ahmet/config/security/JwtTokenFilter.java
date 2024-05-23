package com.ahmet.config.security;

import com.ahmet.exception.ErrorType;
import com.ahmet.exception.UserManagerException;
import com.ahmet.utility.JwtTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    JwtTokenManager jwtTokenManager;
    @Autowired
    JwtUserDetails jwtUserDetails;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        System.out.println("****** Auth Header --> " + authHeader);

        if(authHeader!=null && authHeader.startsWith("Bearer ")
//                && SecurityContextHolder.getContext().getAuthentication()==null
                ) {
            String token = authHeader.substring(7);
            Optional<String> userRole = jwtTokenManager.getRoleFromToken(token);
            if(userRole.isPresent()) { // ya da -> if(jwtTokenManager.validateToken(token)) --> means "if token is valid"  [bu komutu yazarsak da aynı işlevi görür]
                UserDetails userDetails = jwtUserDetails.loadByUserRole(userRole.get());
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }else {
                throw new UserManagerException(ErrorType.INVALID_TOKEN);
            }

        }
        filterChain.doFilter(request,response);

    }
}
