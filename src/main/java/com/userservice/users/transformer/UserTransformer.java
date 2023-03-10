package com.userservice.users.transformer;

import com.userservice.users.entity.AddressEntity;
import com.userservice.users.entity.UserEntity;
import com.userservice.users.model.AddressVO;
import com.userservice.users.model.UserVO;
import com.userservice.users.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTransformer {
    @Autowired
    UserValidator userValidator;

    public UserEntity toEntity(UserVO userVO){
        return UserEntity.builder()
                .firstName(userVO.getFirstName())
                .lastName(userVO.getLastName())
                .email(userVO.getEmail())
                .phoneNumber(userValidator.validatePhoneNumber(userVO.getPhoneNumber()))
                .address1(AddressEntity.builder()
                        .streetName(userVO.getAddress1().getStreetName())
                        .aptNo(userVO.getAddress1().getAptNo())
                        .city(userVO.getAddress1().getCity())
                        .state(userValidator.validateState(userVO.getAddress1().getState()))
                        .zip(userValidator.validateZip(userVO.getAddress1().getZip()))
                        .build())
                .address2(AddressEntity.builder()
                        .streetName(userVO.getAddress2().getStreetName())
                        .aptNo(userVO.getAddress2().getAptNo())
                        .city(userVO.getAddress2().getCity())
                        .state(userValidator.validateState(userVO.getAddress2().getState()))
                        .zip(userValidator.validateZip(userVO.getAddress2().getZip()))
                        .build())
                .build();
    }

    public UserVO fromEntity(UserEntity userEntity){
        return UserVO.builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .phoneNumber(userEntity.getPhoneNumber())
                .address1(AddressVO.builder()
                        .streetName(userEntity.getAddress1().getStreetName())
                        .aptNo(userEntity.getAddress1().getAptNo())
                        .city(userEntity.getAddress1().getCity())
                        .state(userEntity.getAddress1().getState())
                        .zip(userEntity.getAddress1().getZip())
                        .build())
                .address2(AddressVO.builder()
                        .streetName(userEntity.getAddress2().getStreetName())
                        .aptNo(userEntity.getAddress2().getAptNo())
                        .city(userEntity.getAddress2().getCity())
                        .state(userEntity.getAddress2().getState())
                        .zip(userEntity.getAddress2().getZip())
                        .build())
                .build();
    }
}
