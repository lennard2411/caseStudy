package com.example.casestudy;

import com.example.casestudy.controller.BetriebsstellenController;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CaseStudyApplicationTests {

    @Autowired
    private BetriebsstellenController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
