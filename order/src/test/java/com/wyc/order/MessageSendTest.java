package com.wyc.order;

import com.wyc.order.message.StreamClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: wyc
 * @date: 2018/12/18
 */
@Component
public class MessageSendTest extends OrderApplicationTests{

    @Autowired
    private StreamClient streamClient;

    @Test
    public void testSend(){
        streamClient.output().send(MessageBuilder.withPayload("now : " + new Date()).build());
    }

}
