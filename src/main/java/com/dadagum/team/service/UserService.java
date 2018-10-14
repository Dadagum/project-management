package com.dadagum.team.service;

import com.dadagum.team.common.bean.User;

public interface UserService {

    public void add(User User);

    public void delete(int id);

    public User get(int id);

    public void update(User User);
}
