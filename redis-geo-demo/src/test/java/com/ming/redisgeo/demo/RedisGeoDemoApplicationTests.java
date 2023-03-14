package com.ming.redisgeo.demo;

import com.ming.redisgeo.demo.entity.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.connection.RedisGeoCommands.GeoRadiusCommandArgs;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest
class RedisGeoDemoApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {
        /*RedisGeoCommands.GeoLocation<String> stringGeoLocation1 = new RedisGeoCommands.GeoLocation<>("message:shops", new Point(111.54, 27.51));
        RedisGeoCommands.GeoLocation<String> stringGeoLocation2 = new RedisGeoCommands.GeoLocation<>("message:shops", new Point(112.54, 26.51));
        RedisGeoCommands.GeoLocation<String> stringGeoLocation3 = new RedisGeoCommands.GeoLocation<>("message:shops", new Point(113.54, 25.51));
        redisTemplate.opsForGeo().add("shopA",stringGeoLocation1);
        redisTemplate.opsForGeo().add("shopB",stringGeoLocation2);
        redisTemplate.opsForGeo().add("shopC",stringGeoLocation3);
        redisTemplate.opsForGeo().position("shopA")*/
        Shop shopA = new Shop(1, "shopA");
        Shop shopB = new Shop(2, "shopB");
        Shop shopC = new Shop(3, "shopC");
        Shop shopD = new Shop(4, "shopD");
        redisTemplate.opsForGeo().add("cityGeoKey", new Point(111.54, 27.51), shopA);
        redisTemplate.opsForGeo().add("cityGeoKey", new Point(112.54, 26.51), shopB);
        redisTemplate.opsForGeo().add("cityGeoKey", new Point(113.54, 25.51), shopC);
        redisTemplate.opsForGeo().add("cityGeoKey", new Point(113.58, 22.27), shopD);

        List<Point> position = redisTemplate.opsForGeo().position("cityGeoKey", shopA, shopB, shopC, shopD);
        System.out.println(position);

        // 假如我在停车场的地址为111.89 26.13 想去找最近的商品
        Point point = new Point(111.89, 26.13);
        // 设置计量单位为千米
        Metric metric = RedisGeoCommands.DistanceUnit.KILOMETERS;
        Distance distance = new Distance(2000, metric);
        // 对象是封装覆盖的面积,以当前 point 访问的 200 km 查询周围附件的商城
        Circle circle = new Circle(point, distance);

        GeoRadiusCommandArgs args = RedisGeoCommands
                .GeoRadiusCommandArgs
                .newGeoRadiusArgs()
                .includeDistance()
                .includeCoordinates()
                .sortAscending()
                .limit(10);

        GeoResults<RedisGeoCommands.GeoLocation<Object>> geoResults = redisTemplate.opsForGeo().radius("cityGeoKey", circle, args);
        geoResults.forEach(geoLocationGeoResult -> {
            RedisGeoCommands.GeoLocation<Object> content = geoLocationGeoResult.getContent();
            // member 名称，如 shopA
            Object name = content.getName();
            // 对应的经纬度坐标
            Point pos = content.getPoint();
            // 距离中心的距离
            Distance dis = geoLocationGeoResult.getDistance();
            System.out.println("名称：" + name + "\t 经纬度：" + pos + "\t 中心的距离：" + dis);
        });
    }
}
