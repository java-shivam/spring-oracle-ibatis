package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        return userMapper.fetchAllUsers();
    }

    public int addUser(User user) {
        return userMapper.insertUser(user);
    }

    public Map<String, Object> executeStoredProcedure(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("name", null);
        params.put("email", null);
        return userMapper.callStoredProcedure(params);
    }
}