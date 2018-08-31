package com.jk.service.impl;

import com.jk.entity.WebSet;
import com.jk.mapper.WebSetMapper;
import com.jk.service.WebSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @创建人 yangfan zhang
 * @创建时间 2018/8/27 10:56
 * @描述
 */
@Service
public class WebSetServiceImpl implements WebSetService{

    @Autowired
    private WebSetMapper webSetMapper;


    @Override
    public List<WebSet> queryWebSet(String userId) {
        return webSetMapper.queryWebSet(userId);
    }

    @Override
    public void deleteWebSet(String id) {
        webSetMapper.deleteWebSet(id);
    }
}
