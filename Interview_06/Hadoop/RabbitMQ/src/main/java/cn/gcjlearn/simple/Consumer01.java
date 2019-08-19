package cn.gcjlearn.simple;

import cn.gcjlearn.util.RabbitmqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author ：GongCJ
 * @date ：Created in 08-19-2019 14:34
 * @description：
 * @modified By：
 * @version: $
 */
public class Consumer01 {
	private static final String QUEUE_NAME = "test_simple_queue";

	public static void main(String[] args) throws Exception {
		Connection connection = RabbitmqUtils.getConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				String msg = new String(body);
				System.out.println(msg);
			}
		};

		channel.basicConsume(QUEUE_NAME, true, consumer);
	}
}
