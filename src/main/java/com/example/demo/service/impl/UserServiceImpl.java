package com.example.demo.service.impl;

import com.example.demo.constant.Response;
import com.example.demo.constant.Result;
import com.example.demo.constant.ResultCode;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;

    @Override
    public Map<String, Object> findAll(int pageNo, int pageSize) {
        Map<String, Object> map = new HashMap<>(16);
        PageHelper.startPage(pageNo, pageSize);
        List<User> userList = userMapper.findAll();
        PageInfo<?> pageInfo = new PageInfo<>(userList);
        map.put("rows", userList);
        map.put("total", pageInfo.getTotal());
        return map;
    }
}
