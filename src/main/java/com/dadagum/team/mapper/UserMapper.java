package com.dadagum.team.mapper;

import com.dadagum.team.common.bean.User;

public interface UserMapper {

    public void insert(User user);

    public void deleteById(int id);

    public User selectById(int id);

    public void update(User user);
}
