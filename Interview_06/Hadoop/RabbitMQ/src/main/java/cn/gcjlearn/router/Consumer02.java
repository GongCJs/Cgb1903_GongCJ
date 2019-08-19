package cn.gcjlearn.router;

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
	private static final String EXCHANGE_NAME = "test_router_exchange";
	private static final String EXCHANGE_TYPE = "direct";
	private static final String CONSUME_TAG = "warning";

	public static void main(String[] args) throws Exception {
		Connection connection = RabbitmqUtils.getConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);
		//生成一个：非持久、排他(独占)，自动删除的队列，并且获取名称
		String queueName = channel.queueDeclare().getQueue();
		//消息队列与交换器绑定
		channel.queueBind(queueName, EXCHANGE_NAME, CONSUME_TAG);

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
