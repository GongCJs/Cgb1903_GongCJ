package cn.gcjlearn.topic;

import cn.gcjlearn.util.RabbitmqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author ：GongCJ
 * @date ：Created in 08-20-2019 10:17
 * @description：
 * @modified By：
 * @version: $
 */
public class Consumer03 {
	private static final String EXCHANGE_NAME = "test_topic_exchange";
	private static final String EXCHANGE_TYPE = "topic";
	private static final String TOPIC_TYPE = "lazy.#";

	public static void main(String[] args) throws Exception {
		Connection connection = RabbitmqUtils.getConnection();
		Channel channel = connection.createChannel();
		channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);
		String queueName = channel.queueDeclare().getQueue();
		channel.queueBind(queueName, EXCHANGE_NAME, TOPIC_TYPE);
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				String msg = new String(body);
				System.out.println(msg);
				try {
					Long sleep = new Long(msg.substring(msg.length() - 1)) * 1000;
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		channel.basicConsume(queueName, true, consumer);
	}
}
