package com.sc.work;

import com.rabbitmq.client.*;
import com.sc.Utils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author ZhPJ
 * @Date 2018/11/9 000915:54
 * @Version 1.0
 * @Description:
 */
public class ReceiveWorkMsg {

    public static void main(String[] args) throws IOException, TimeoutException {
        final Connection connection = Utils.createConnection();
        final Channel channel = connection.createChannel();
        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                System.out.println(" [x] Received '" + message + "'");
                try {

                } finally {
                    System.out.println(" [x] Done");
                }
            }
        };
    }

}
