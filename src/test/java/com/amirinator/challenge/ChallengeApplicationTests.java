package com.amirinator.challenge;

import ch.qos.logback.classic.ViewStatusMessagesServlet;
import com.amirinator.challenge.model.Visit;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.ParameterizedType;
import java.sql.Timestamp;

@SpringBootTest
@RunWith(Parameterized.class)
class ChallengeApplicationTests {

    private Integer productId;
    private Integer userId;
    private Timestamp visitTimestamp;
    private Visit visit;

    public ChallengeApplicationTests(Integer productId, Integer userId, Timestamp visitTimestamp) {
        super();
        this.productId = productId;
        this.userId = userId;
        this.visitTimestamp = visitTimestamp;
    }

    @Before
    public void initialize() {
        visit = new Visit();
    }


    @Test
    void contextLoads() {
    }

    @Test
    void testVisitCreation() {

        Visit visit = new Vist
    }
}
