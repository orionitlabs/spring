package com.userservice.users.service;

import com.userservice.users.entity.AddressEntity;
import com.userservice.users.entity.UserEntity;
import com.userservice.users.model.AddressVO;
import com.userservice.users.model.UserVO;
import com.userservice.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserVO addNewUser(UserVO userVO){
        Optional<UserEntity> isUserPresent = userRepository.findByEmail(userVO.getEmail());
        if(isUserPresent.isEmpty()){
            UserEntity userEntity = UserEntity.builder()
                    .firstName(userVO.getFirstName())
                    .lastName(userVO.getLastName())
                    .email(userVO.getEmail())
                    .phoneNumber(userVO.getPhoneNumber())
                    .address1(AddressEntity.builder()
                            .streetName(userVO.getAddress1().getStreetName())
                            .aptNo(userVO.getAddress1().getAptNo())
                            .city(userVO.getAddress1().getCity())
                            .state(userVO.getAddress1().getState())
                            .zip(userVO.getAddress1().getZip())
                            .build())
                    .address2(AddressEntity.builder()
                            .streetName(userVO.getAddress2().getStreetName())
                            .aptNo(userVO.getAddress2().getAptNo())
                            .city(userVO.getAddress2().getCity())
                            .state(userVO.getAddress2().getState())
                            .zip(userVO.getAddress2().getZip())
                            .build())
                    .build();
            UserEntity user = userRepository.save(userEntity);

            return UserVO.builder()
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .phoneNumber(user.getPhoneNumber())
                    .address1(AddressVO.builder()
                            .streetName(user.getAddress1().getStreetName())
                            .aptNo(user.getAddress1().getAptNo())
                            .city(user.getAddress1().getCity())
                            .state(user.getAddress1().getState())
                            .zip(user.getAddress1().getZip())
                            .build())
                    .address2(AddressVO.builder()
                            .streetName(user.getAddress2().getStreetName())
                            .aptNo(user.getAddress2().getAptNo())
                            .city(user.getAddress2().getCity())
                            .state(user.getAddress2().getState())
                            .zip(user.getAddress2().getZip())
                            .build())
                    .build();
        }else
            throw new RuntimeException("User Already Present");

    }

    public List<UserVO> addNewUsers(List<UserVO> userVO) {
        return userVO.stream().map(this::addNewUser).collect(Collectors.toList());
    }

    public UserVO getUser(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if (user.isPresent()){
            return UserVO.builder()
                    .firstName(user.get().getFirstName())
                    .lastName(user.get().getLastName())
                    .email(user.get().getEmail())
                    .phoneNumber(user.get().getPhoneNumber())
                    .address1(AddressVO.builder()
                            .streetName(user.get().getAddress1().getStreetName())
                            .aptNo(user.get().getAddress1().getAptNo())
                            .city(user.get().getAddress1().getCity())
                            .state(user.get().getAddress1().getState())
                            .zip(user.get().getAddress1().getZip())
                            .build())
                    .address2(AddressVO.builder()
                            .streetName(user.get().getAddress2().getStreetName())
                            .aptNo(user.get().getAddress2().getAptNo())
                            .city(user.get().getAddress2().getCity())
                            .state(user.get().getAddress2().getState())
                            .zip(user.get().getAddress2().getZip())
                            .build())
                    .build();
        }else {
            throw new RuntimeException("User not present");
        }
    }
}
