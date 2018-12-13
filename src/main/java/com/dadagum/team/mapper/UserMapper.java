package com.dadagum.team.mapper;

import com.dadagum.team.common.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    void insertUser(@Param("user") User user);//

    boolean checkUserName(@Param("name") String name);

    boolean checkUserPhone(@Param("phone") String phone);

    boolean checkUserLogin(@Param("name") String name,@Param("password") String password);

    void deleteUserById(@Param("id") int id);//

    User getUserById(@Param("id") int id);//

    void updateUser(@Param("user") User user);//

    int countUserPhone(@Param("phone") String phone);

    String getSalt(@Param("name") String name);//

    int countUserByNameAndPassword(@Param("user") User user);

    String  getUserRole(@Param("id") int id);//

    User getUserByName(@Param("name") String name);
}
