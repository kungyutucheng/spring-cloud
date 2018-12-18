package com.wyc.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author: wyc
 * @date: 2018/12/18
 */
public interface StreamClient {

    String INPUT = "myMessage";

    @Input("myMessageInput")
    SubscribableChannel input1();

    @Output(StreamClient.INPUT)
    MessageChannel output();
}
