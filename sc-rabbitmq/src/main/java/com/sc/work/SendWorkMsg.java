package com.sc.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.sc.Utils;

import javax.rmi.CORBA.Util;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author ZhPJ
 * @Date 2018/11/9 000915:46
 * @Version 1.0
 * @Description:
 */
public class SendWorkMsg {

    public static void main(String[] args) throws IOException, TimeoutException {
        final Connection connection = Utils.createConnection();
        final Channel channel = connection.createChannel();
        channel.basicPublish("", "hello", null, "你好啊 this is work".getBytes());
        Utils.closeConnection(connection, channel);
    }

}
