package com.dadagum.team.common.validator;

import com.dadagum.team.common.bean.User;

public class UserValidator {

    private UserValidator(){
    }

    public static boolean checkForRegistration(User user){
        return true;
    }

    public static boolean checkForLogin(User user){
        return true;
    }
}
