package com.dsys.service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MessageService {
    private ConnectionFactory factory = new ConnectionFactory();


    public boolean sendMessage(String to, String message, String customer_id) throws Exception {
        factory.setPort(30003);
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.exchangeDeclare("spring_app", "direct");


            channel.basicPublish("spring_app", to, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + to + "':'" + message + "'");
        }
        return true;
    }



}
