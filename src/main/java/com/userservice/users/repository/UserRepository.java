package com.userservice.users.repository;

import com.userservice.users.entity.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, ObjectId> {
    Optional<UserEntity> findByEmail(String email);
}
