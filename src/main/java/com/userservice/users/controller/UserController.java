package com.userservice.users.controller;

import com.userservice.users.model.UserVO;
import com.userservice.users.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "v1/users")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserVO addNewUser(@RequestBody UserVO userVO){
        log.info("FirstName: {}, LastName: {}", userVO.getFirstName(), userVO.getLastName());
        return userService.addNewUser(userVO);
    }
    @PostMapping(path = "/add/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserVO> addNewUsers(@RequestBody List<UserVO> userVO){
        return userService.addNewUsers(userVO);
    }
    @GetMapping(path = "/get/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserVO getSingleUser(@RequestParam(required = true, defaultValue = "") String email){
        return userService.getUser(email);
    }
    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserVO updateUser(@RequestBody UserVO userVO){
        return userService.updateUserDetails(userVO);
    }
    @DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserVO deleteUser(@RequestParam(required = true, defaultValue = "") String email){
        return userService.deleteUser(email);
    }

}
