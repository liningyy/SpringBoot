package com.ming.city.service.impl;

import com.github.pagehelper.PageInfo;
import com.ming.city.dao.CityDao;
import com.ming.city.pojo.CityInfo;
import com.ming.city.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author 贺春明
 * @date 2023/2/16
 */

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityDao cityDao;

    @Override
    public PageInfo<CityInfo> listCity(Integer pageNum, Integer pageSize) {
        return new PageInfo<>(cityDao.listCity(pageNum, pageSize));
    }
}
