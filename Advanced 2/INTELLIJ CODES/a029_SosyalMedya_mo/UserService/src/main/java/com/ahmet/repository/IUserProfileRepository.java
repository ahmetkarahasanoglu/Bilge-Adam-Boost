package com.ahmet.repository;

import com.ahmet.repository.entity.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserProfileRepository extends MongoRepository<UserProfile,String> {

    Optional<UserProfile> findOptionalByAuthId(Long authId);

    Optional<UserProfile> findOptionalByUsernameIgnoreCase(String username);

    Optional<List<UserProfile>> findAllByAuthIdIn(List<Long> authidsList);
}
