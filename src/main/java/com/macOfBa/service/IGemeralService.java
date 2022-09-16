package com.macOfBa.service;

import com.macOfBa.model.Motor;

import java.util.List;

public interface IGemeralService<T>{
    List<Motor> findAll();
    T findById(int id);
    void save(T t);
    void remove(int id);
}
