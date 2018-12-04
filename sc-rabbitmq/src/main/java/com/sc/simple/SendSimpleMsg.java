package com.sc.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.sc.Utils;

import javax.swing.event.ChangeEvent;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author ZhPJ
 * @Date 2018/11/9 000915:04
 * @Version 1.0
 * @Description:
 */

public class SendSimpleMsg {

    public final static String QUEUE = "hello";

    public static void main (String[] a) throws IOException, TimeoutException {
        final Connection connection = Utils.createConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE, false, false, false, null);
        channel.basicPublish("", QUEUE, null, "发送者".getBytes());
        System.out.println("this is send");
        Utils.closeConnection(connection, channel);
    }

}
