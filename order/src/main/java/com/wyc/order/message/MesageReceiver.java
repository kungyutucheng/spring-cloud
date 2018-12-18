package com.wyc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author: wyc
 * @date: 2018/12/18
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class MesageReceiver {

    @StreamListener(StreamClient.INPUT)
    public void receive(Object object){
        log.info("接收到消息：{}",object);
    }
}
