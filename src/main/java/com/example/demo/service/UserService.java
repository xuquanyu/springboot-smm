package com.example.demo.service;

import java.util.Map;

public interface UserService {

    Map<String, Object> findAll(int pageNo, int pageSize);
}
