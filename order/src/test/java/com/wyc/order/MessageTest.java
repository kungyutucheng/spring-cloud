package com.wyc.order;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: wyc
 * @date: 2018/12/6
 */
@Component
public class MessageTest extends OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void test(){
        amqpTemplate.convertAndSend("myQueue","test");
    }

    @Test
    public void testSendComputer(){
        amqpTemplate.convertAndSend("myOrder","computer","test");
    }
}
