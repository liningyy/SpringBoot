package com.ming.city.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 贺春明
 * @date 2023/2/16
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "CityInfo",description = "城市信息")
public class CityInfo {
        @Schema(name = "cityId",description = "城市编号",example = "1001")
        private String cityId;
        @Schema(name = "cityName",description = "城市名称",example = "深圳")
        private String cityName;
        @Schema(name = "cityCode",description = "城市编码",example = "2002023")
        private String cityCode;
        @Schema(name = "province",description = "地区名称",example = "南沙区")
        private String province;
}
