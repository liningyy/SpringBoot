package com.ming.ch12.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 贺春明
 * @date 2023/2/22
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String sendUser;
    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "GMT+8")
    private Date date;
    /**
     * 私发用户的id
     */
    private String uid;

}
