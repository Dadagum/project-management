package com.dadagum.team;

import com.dadagum.team.common.model.User;
import com.dadagum.team.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        //userMapper.insertUser(new User("nick","123","123","USER","1231","2016-10-16"));
        boolean x=userMapper.checkUserName("nick");
        System.out.println(x);
    }
}
