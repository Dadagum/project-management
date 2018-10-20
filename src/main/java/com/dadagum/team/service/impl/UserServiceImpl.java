package com.dadagum.team.service.impl;

import com.dadagum.team.common.bean.User;
import com.dadagum.team.common.exception.def.UserAuthenticationException;
import com.dadagum.team.mapper.UserMapper;
import com.dadagum.team.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        if (ifUserExist(user)){
            throw new UserAuthenticationException("手机已经被注册");
        }
        userMapper.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUserById(id);
    }

    @Override
    public User getUser(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public String login(User user) {
        String salt = userMapper.getSalt(user.getId());
        if (salt == null){
            throw new UserAuthenticationException("用户名或者密码错误");
        }

        // TODO
    }

    private boolean ifUserExist(User user){
        return userMapper.ifUserExist(user.getPhone()) == 1;
    }
}
