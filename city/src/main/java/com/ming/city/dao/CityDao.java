package com.ming.city.dao;

import com.ming.city.pojo.CityInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 贺春明
 * @date 2023/2/16
 */

public interface CityDao {
    /**
     * 根据分页参数查询城市信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<CityInfo> listCity(@Param("pageNum") Integer pageNum,
                            @Param("pageSize") Integer pageSize);
}
