package com.ha.springbootjpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
@Slf4j
class SpringbootJpaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    DataSource dataSource;

    @Test
    @DisplayName("커넥션 테스트")
    public void conn() throws Exception{
        Connection con = dataSource.getConnection();
        log.info("DBCP : {}",dataSource.getClass());
        log.info("URL : {}",con.getMetaData().getURL());
        log.info("Username : {}",con.getMetaData().getUserName());
    }

}
