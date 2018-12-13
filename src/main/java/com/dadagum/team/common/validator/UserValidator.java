package com.dadagum.team.common.validator;

import com.dadagum.team.common.exception.def.UserRegistrationException;
import com.dadagum.team.common.model.User;
import com.dadagum.team.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    private static UserMapper userMapper;
    @Autowired
    private UserValidator(UserMapper userMapper){
        this.userMapper=userMapper;
    }

    public static boolean checkForRegistration(User user){
        if(!userMapper.checkUserName(user.getUserName())){
            if(!userMapper.checkUserPhone(user.getPhone()))
            {
                return true;
            }
        }
        return false;
    }

//    public static boolean checkForLogin(User user){
//        if(userMapper)
//        return true;
//    }
}
