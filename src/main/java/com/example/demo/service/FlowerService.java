package com.example.demo.service;


import com.example.demo.entity.Count;
import com.example.demo.entity.Flower;

import java.util.List;

public interface FlowerService {

    int publish(String name, String description, String avatar, String id);

    List<Flower> getByPage(Integer offset, Integer pageSize);

    int deleteById(String id);

    Flower getById(String id);

    int updateInfo(String name, String description, String avatar, String id);

    List<Count> getCount();
}
