package com.ming.redisgeo.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 贺春明
 * @date 2023/3/14
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop implements Serializable {
    private Integer id;
    private String name;
}
