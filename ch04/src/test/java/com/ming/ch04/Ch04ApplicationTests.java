package com.ming.ch04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
class Ch04ApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testDruid() throws SQLException {
        log.info(dataSource.toString());
        log.info(dataSource.getConnection().toString());
    }

    @Test
    void testJDBCQuery() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user_info");
        list.forEach(map -> {
            log.info(map.toString());
        });

        for (Map<String, Object> stringObjectMap : list) {
            for (Map.Entry<String, Object> map : stringObjectMap.entrySet()) {
                log.info(map.getKey()+"");
            }
        }
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class User {
    private int uid;
    private String account;
    private String password;
    private String userName;
}
