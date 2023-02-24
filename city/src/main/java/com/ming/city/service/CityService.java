package com.ming.city.service;

import com.github.pagehelper.PageInfo;
import com.ming.city.pojo.CityInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author 贺春明
 * @date 2023/2/16
 */

public interface CityService {
    PageInfo<CityInfo> listCity(@Param("pageNum") Integer pageNum,
                                @Param("pageSize") Integer pageSize);
}
