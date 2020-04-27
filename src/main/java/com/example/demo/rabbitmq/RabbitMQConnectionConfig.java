//package com.example.demo.rabbitmq;
//
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQConnectionConfig {
//    @Value("${spring.rabbitmq.host}")
//    public String host;
//
//    @Value("${spring.rabbitmq.port}")
//    public int port;
//
//    @Value("${spring.rabbitmq.username}")
//    public String username;
//
//    @Value("${spring.rabbitmq.password}")
//    public String password;
//
//    @Value("${spring.rabbitmq.virtual-host}")
//    public String virtualHost;
//
//    @Bean
//    public ConnectionFactory getConnectionFactory(){
//        CachingConnectionFactory factory=new CachingConnectionFactory();
//        factory.setHost(host);
//        factory.setPort(port);
//        factory.setUsername(username);
//        factory.setPassword(password);
//        factory.setVirtualHost(virtualHost);
//        return factory;
//    }
//}
