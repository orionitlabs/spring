package com.userservice.users.service;

import com.userservice.users.entity.AddressEntity;
import com.userservice.users.entity.UserEntity;
import com.userservice.users.model.AddressVO;
import com.userservice.users.model.UserVO;
import com.userservice.users.repository.UserRepository;
import com.userservice.users.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserTransformer userTransformer;

    public UserVO addNewUser(UserVO userVO){
        Optional<UserEntity> isUserPresent = userRepository.findByEmail(userVO.getEmail());
        if(isUserPresent.isEmpty()){
            return userTransformer.fromEntity(userRepository.save(userTransformer.toEntity(userVO)));
        }else
            throw new RuntimeException("User Already Present");

    }

    public List<UserVO> addNewUsers(List<UserVO> userVO) {
        return userVO.stream().map(this::addNewUser).collect(Collectors.toList());
    }

    public UserVO getUser(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if (user.isPresent()){
            return userTransformer.fromEntity(user.get());
        }else {
            throw new RuntimeException("User not present");
        }
    }

    public UserVO updateUserDetails(UserVO userVO) {
        //checking weather record exists or not
        Optional<UserEntity> user = userRepository.findByEmail(userVO.getEmail());
        if(user.isPresent()){ //if record found
            UserEntity userEntity = userTransformer.toEntity(userVO);
            //Since record already exists we have assign primary key
            userEntity.setId(user.get().getId());
            return userTransformer.fromEntity(userRepository.save(userEntity));
        }else { //if record not exists throwing exception
            throw new RuntimeException("User not present");
        }
    }

    public UserVO deleteUser(String email) {
        //checking weather record exists or not
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            //will delete that particular user
            userRepository.delete(user.get());
            return userTransformer.fromEntity(user.get());
        }else { //if record not exists throwing exception
            throw new RuntimeException("User not present");
        }
    }
}