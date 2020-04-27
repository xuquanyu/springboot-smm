package com.example.demo.controller;

import com.example.demo.constant.Response;
import com.example.demo.constant.Result;
import com.example.demo.rabbitmq.RabbitMQBindingConfig;
import com.example.demo.service.UserService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("demo")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/selectUser")
    public Result<?> findAll(int pageNo, int pageSize) {
        return Response.makeOKRsp(userService.findAll(pageNo, pageSize));
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public void send() {
        for (int n = 0; n < 10; n++) {
            template.convertAndSend(RabbitMQBindingConfig.Exchange_NAME, RabbitMQBindingConfig.RoutingKey1, "I'm the " +
                    "first queue!   " + String.valueOf(n), getCorrelationData());
            template.convertAndSend(RabbitMQBindingConfig.Exchange_NAME, RabbitMQBindingConfig.RoutingKey2, "I'm the " +
                    "second queue!  " + String.valueOf(n), getCorrelationData());
        }
    }

    private CorrelationData getCorrelationData() {
        return new CorrelationData(UUID.randomUUID().toString());
    }

}
