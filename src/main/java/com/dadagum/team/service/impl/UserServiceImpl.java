package com.dadagum.team.service.impl;

import com.dadagum.team.common.model.Role;
import com.dadagum.team.common.model.User;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.exception.def.UserAuthenticationException;
import com.dadagum.team.common.utils.DigestUtil;
import com.dadagum.team.common.utils.JWTUtils;
import com.dadagum.team.common.validator.UserValidator;
import com.dadagum.team.mapper.GroupMapper;
import com.dadagum.team.mapper.ProjectMapper;
import com.dadagum.team.mapper.UserMapper;
import com.dadagum.team.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private ProjectMapper projectMapper;

    // jwt的有效时间，单位：毫秒
    private static final int JWT_AGE = 3600000;

    @Override
    public void insertUser(User user) {
        if (UserValidator.checkForRegistration(user)) {
            String salt = DigestUtil.createSalt();
            user.setSalt(salt);

            String encodedPwd = DigestUtil.md5Hash(user.getPassword(), salt);
            user.setPassword(encodedPwd);

            userMapper.insertUser(user);
        }
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUserById(id);
    }

    @Override
    public User getUser(int id) {
        // userMapper.getUserById(id);
        return new User("朱世靖", Role.USER.value());
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public String login(User user) {
        String salt = userMapper.getSalt(user.getId());

        // 用户不存在，但是为了不让外界知道用户名是否存在，所以返回的信息为“用户名或者密码错误”
        if (salt == null){
            throw new UserAuthenticationException("用户名或者密码错误");
        }

        String encodedPwd = DigestUtil.md5Hash(user.getPassword(), salt);
        user.setPassword(encodedPwd);
        if (!checkPassword(user)){
            throw new UserAuthenticationException("用户名或者密码错误");
        }

        // 生成jwt
        String role = userMapper.getUserRole(user.getId());
        JwtUserDTO jwtUserDTO = new JwtUserDTO(user.getId(), role);
        String jwt = JWTUtils.createToken(jwtUserDTO, JWT_AGE);

        return jwt;
    }

    private boolean ifUserExist(User user){
        return userMapper.countUserPhone(user.getPhone()) == 1;
    }

    private boolean checkPassword(User user){
        return userMapper.countUserByNameAndPassword(user) == 1;
    }

//    private Map<Integer, List<Integer>> getUserProject(int uid, List<Integer> projects){
//        List<Integer> teams = groupMapper.listUserGroup(uid);
//        for (Integer teamId : teams){
//
//        }
//    }
}
