package com.sc;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author ZhPJ
 * @Date 2018/11/9 000915:49
 * @Version 1.0
 * @Description:
 */
public class Utils {

    public static Connection createConnection () throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        final Connection connection = connectionFactory.newConnection();
        return connection;
    }

    public static void closeConnection (Connection connection, Channel channel) throws IOException, TimeoutException {
        channel.close();
        connection.close();
    }

}
