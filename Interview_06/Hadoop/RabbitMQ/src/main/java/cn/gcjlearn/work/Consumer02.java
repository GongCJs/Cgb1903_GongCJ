package cn.gcjlearn.work;

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
public class Consumer02 {
	private static final String QUEUE_NAME = "test_work_queue";

	public static void main(String[] args) throws Exception {
		Connection connection = RabbitmqUtils.getConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
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
				channel.basicAck(envelope.getDeliveryTag(), false);
			}
		};

		channel.basicConsume(QUEUE_NAME, false, consumer);
	}
}
