package com.sc.simple;

import com.rabbitmq.client.*;
import com.sc.Utils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author ZhPJ
 * @Date 2018/11/9 000915:25
 * @Version 1.0
 * @Description:
 */
public class ReceiveSimpleMsg {

    public static final String QUEUE = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        final Connection connection = Utils.createConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE, false, false, false, null);
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };

        channel.basicConsume(QUEUE, true, consumer);
        Utils.closeConnection(connection, channel);
    }

}
