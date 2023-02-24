package com.ming.ch07;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
@Slf4j
class Ch07ApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Test
    void testDataSource() {
        ComboPooledDataSource ds = (ComboPooledDataSource) dataSource;
        log.info(String.valueOf(ds.getMinPoolSize()));
        log.info(String.valueOf(ds.getInitialPoolSize()));
        log.info(String.valueOf(ds.getMaxPoolSize()));
    }

}
