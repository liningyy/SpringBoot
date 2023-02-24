package com.ming.ch06.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 贺春明
 * @date 2023/2/17
 */

@Schema(name = "Card",description = "身份证信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    @Schema(name = "cardNum",description = "身份证号",example = "21421312513421213")
    private String cardNum;
}
