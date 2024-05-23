package com.ahmet.controller;

import com.ahmet.repository.entity.UserProfile;
import com.ahmet.service.UserProfileService;

import java.util.Scanner;

public class UserProfileController {

    private Scanner scanner;
    private UserProfileService userProfileService;
    private TweetController tweetController;

    // CONSTRUCTOR:
    public UserProfileController() {
        scanner =new Scanner(System.in);
        userProfileService = new UserProfileService();
        tweetController = new TweetController();
    }

    public void register() {
        boolean isRegisterSuccessful = false;
        do{
            System.out.println();
            System.out.println("**********************************");
            System.out.println("********** REGISTER PAGE *********");
            System.out.println("**********************************");
            System.out.println();
            System.out.print("Kullanıcı adı......: ");
            String username = scanner.nextLine();
            System.out.print("Sifre..............: ");
            String password = scanner.nextLine();
            System.out.print("Sifre doğrulama..: ");
            String repassword = scanner.nextLine();
            if(password.equals(repassword)) {
                boolean isUsernameExist = userProfileService.existByUsername(username);
                if(isUsernameExist) {
                    System.out.println("Bu kullanıcı adı kullanılmaktadır.");
                }else {
                    userProfileService.save(UserProfile.builder().username(username).password(password).build());
                    isRegisterSuccessful = true;
                    System.out.println("KULLANICI BASARIYLA KAYIT EDİLDİ.");
                }
            }else {
                System.out.println("sifre ve doğrulama sifresi uyuşmamaktadır.");
            }
        }while(isRegisterSuccessful == false);
    }

    public void login() {
        System.out.println();
        System.out.println("**********************************");
        System.out.println("********** LOGIN PAGE ************");
        System.out.println("**********************************");
        System.out.println();
        System.out.print("Username........: ");
        String username = scanner.nextLine();
        System.out.print("Password......: ");
        String password = scanner.nextLine();
        /**
         * Kullanıcı adı ve şifre doğrulanırken kullanıcıya "şifre
         * yanlıştır" veya "böyle bir kullanıcı bulunmamaktadır"
         * bilgisi geçmeyiniz. Güvenlik zafiyeti oluşturur.
         */
        boolean login = userProfileService.doLogin(username, password);

        if(login) {
            System.out.println("GİRİS BASARILI.");
            tweetController.userPage(username);
        }else {
            System.out.println("Kullanıcı adı veya şifre hatalıdır.");
        }

    }
}
