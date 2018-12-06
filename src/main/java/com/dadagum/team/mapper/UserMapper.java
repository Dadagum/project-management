package com.dadagum.team.mapper;

import com.dadagum.team.common.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    public void insertUser(@Param("user") User user);//

    public void deleteUserById(@Param("id") int id);//

    public User getUserById(@Param("id") int id);//

    public void updateUser(@Param("user") User user);//

    public int countUserPhone(@Param("phone") String phone);

    public String getSalt(@Param("id") int id);//

    public int countUserByNameAndPassword(User user);

    public int  getUserRole(@Param("id") int id);//


}
