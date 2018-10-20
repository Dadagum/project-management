package com.dadagum.team.service;

import com.dadagum.team.common.bean.User;

public interface UserService {

    public void addUser(User User);

    public void deleteUser(int id);

    public User getUser(int id);

    public void updateUser(User User);

    public String login(User user);
}
