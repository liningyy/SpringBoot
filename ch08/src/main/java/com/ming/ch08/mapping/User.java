package com.ming.ch08.mapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;

/**
 * @author 贺春明
 * @date 2023/2/21
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "user",createIndex = false)
@Mapping
public class User {

    @Id
    private Integer id;
    @Field(type = FieldType.Keyword)
    private String name;
    @Field(type = FieldType.Integer)
    private Integer age;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String birthplace;
}
