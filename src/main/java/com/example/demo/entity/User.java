package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {

    private String name;

    private Integer gender;

}
