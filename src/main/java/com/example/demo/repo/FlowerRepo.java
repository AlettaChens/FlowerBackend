package com.example.demo.repo;


import com.example.demo.entity.Count;
import com.example.demo.entity.Flower;
import com.example.demo.mapper.FlowerMapper;
import com.example.demo.service.FlowerService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


@Component
public class FlowerRepo implements FlowerService {
    @Resource
    private FlowerMapper flowerMapper;


    @Override
    public int publish(String name, String description, String avatar, String id) {
        return flowerMapper.publish(id, name, description, avatar);
    }

    @Override
    public int deleteById(String id) {
        return flowerMapper.deleteById(id);
    }

    @Override
    public int updateInfo(String name, String description, String avatar, String id) {
        return flowerMapper.updateInfo(name, description, avatar, id);
    }

    @Override
    public List<Flower> getByPage(Integer offset, Integer pageSize) {
        return flowerMapper.getByPage((offset - 1) * pageSize, pageSize);
    }

    @Override
    public List<Count> getCount() {
        return flowerMapper.getCount();
    }


    @Override
    public Flower getById(String id) {
        return flowerMapper.getById(id);
    }
}
