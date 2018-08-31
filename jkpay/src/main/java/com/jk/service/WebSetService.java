package com.jk.service;

import com.jk.entity.WebSet;

import java.util.List;

/**
 * @创建人 yangfan zhang
 * @创建时间 2018/8/27 10:55
 * @描述
 */
public interface WebSetService {

    List<WebSet> queryWebSet(String userId);

    void deleteWebSet(String id);
}
