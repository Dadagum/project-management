package com.dadagum.team.service;

public interface AuthService {

    void checkIfGroupLeader(int uid, int gid);

    void checkIfGroupMember(int uid, int gid);
}
