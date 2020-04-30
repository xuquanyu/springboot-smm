package com.example.demo.controller;

import com.example.demo.constant.Response;
import com.example.demo.constant.Result;
import com.example.demo.rabbitmq.RabbitMQBindingConfig;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api("用户服务")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/selectUser")
    @ApiOperation(value = "用户分页查询", notes = "查询所有用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录条数", required = true, dataType = "Integer")
    })
    public Result<?> findAll(Integer pageNo, Integer pageSize) {
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
