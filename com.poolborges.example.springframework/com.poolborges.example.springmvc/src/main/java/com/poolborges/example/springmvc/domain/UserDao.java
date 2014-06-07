package com.poolborges.example.springmvc.domain;

public interface UserDao {
  User getForUsername(String username);
}