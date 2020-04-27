package com.example.demo;

import com.example.demo.sort.IdIncrement;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    IdIncrement idIncrement;
    @Test
    void contextLoads() {
//        for (int i = 0; i < 5; i++) {
//            long id = idIncrement.getIncrementId("001");
//            String id = idIncrement.getIncrementIdStr("JXS001");
              idIncrement.getIncrementIdStrV2();
//        }
    }

}
