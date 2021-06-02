package com.kwetter.followservice.rabbit;

import com.kwetter.followservice.service.FollowService;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @Autowired
    private FollowService followService;

    @RabbitListener(queuesToDeclare = @Queue(name = RabbitMQConfig.queueName, durable = "false"))
    public void receivedForget(String username) {
        System.out.println("Forget: received " + username);
        followService.deleteAllByUsername(username);
    }
}
