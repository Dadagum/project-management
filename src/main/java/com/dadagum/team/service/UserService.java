package com.dadagum.team.service;

import com.dadagum.team.common.model.User;

public interface UserService {

    public void insertUser(User User);

    public void deleteUser(int id);

    public User getUser(int id);

    public void updateUser(User User);

    public String login(User user);
}
