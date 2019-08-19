package cn.gcjlearn.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ：GongCJ
 * @date ：Created in 08-19-2019 10:34
 * @description：RabbitMQ 连接工具
 * @modified By：
 * @version: $
 */
public class RabbitmqUtils {
	private RabbitmqUtils() {
	}

	public static Connection getConnection() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("192.168.11.11");
		factory.setPort(5672);
//		factory.setVirtualHost("/root");
		factory.setUsername("root");
		factory.setPassword("root");
		return factory.newConnection();
	}

	@Deprecated
	public static Channel getChannel() throws IOException, TimeoutException {
		return getConnection().createChannel();
	}

}
