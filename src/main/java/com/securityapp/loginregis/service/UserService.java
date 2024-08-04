package com.securityapp.loginregis.service;

import com.securityapp.loginregis.dto.UserDto;
import com.securityapp.loginregis.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUser();
    User saveUser(UserDto userDto);


}
