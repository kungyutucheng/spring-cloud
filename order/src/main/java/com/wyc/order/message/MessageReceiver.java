package com.wyc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: wyc
 * @date: 2018/12/6
 */
@Slf4j
@Component
public class MessageReceiver {

    //需要手动添加队列
    // @RabbitListener(queues = "myQueue")
    //自动添加队列
    // @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    @RabbitListener(bindings = @QueueBinding(value = @Queue("myQueue"),exchange = @Exchange("myExchange")))
    public void receive(String message){
        log.info("receive : {}",message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("computerQueue"),key = "computer",exchange = @Exchange("myOrder")))
    public void receiveComputer(String message){
        log.info("commpute:{}",message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("fruitQueue"),key = "fruit",exchange = @Exchange("myOrder")))
    public void receiveFruit(String message){
        log.info("fruit:{}",message);
    }

}
