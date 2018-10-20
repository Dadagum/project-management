package com.dadagum.team.mapper;

import com.dadagum.team.common.bean.User;

public interface UserMapper {

    public void addUser(User user);

    public void deleteUserById(int id);

    public User getUserById(int id);

    public void updateUser(User user);

    public int ifUserExist(String phone);

    public String getSalt(int id);

    public int userAuth(User user);

}
