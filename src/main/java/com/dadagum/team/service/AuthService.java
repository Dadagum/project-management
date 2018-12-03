package com.dadagum.team.service;

public interface AuthService {

    void checkIfGroupLeader(int uid, int gid);

    void checkIfGroupMember(int uid, int gid);

    void checkIfProjectMember(int uid,int pid);

    void checkIfProjectLeader(int uid,int pid);

    void checkIfMissionMember(int uid,int mid);

    void checkIfMissionLeader(int uid,int mid);
}
