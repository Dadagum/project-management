package com.dadagum.team.common.dto;

import java.util.List;
import java.util.Map;

public class RedisUserInfo {

    private Map<Integer, List<Integer>> project;
    private Map<Integer, List<Integer>> task;


    public RedisUserInfo() {
    }

    public RedisUserInfo(Map<Integer, List<Integer>> project, Map<Integer, List<Integer>> task) {
        this.project = project;
        this.task = task;
    }

    public Map<Integer, List<Integer>> getProject() {
        return project;
    }

    public void setProject(Map<Integer, List<Integer>> project) {
        this.project = project;
    }

    public Map<Integer, List<Integer>> getTask() {
        return task;
    }

    public void setTask(Map<Integer, List<Integer>> task) {
        this.task = task;
    }
}
