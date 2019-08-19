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
public class Consumer01 {
	private static final String EXCHANGE_NAME = "test_router_exchange";
	//指定交换器类型，在使用路由器的模式下必须使用“direct”类型的交换器
	private static final String EXCHANGE_TYPE = "direct";
	//指定绑定键类型
	private static final String CONSUME_TAG = "error";

	public static void main(String[] args) throws Exception {
		Connection connection = RabbitmqUtils.getConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);
		//生成一个：非持久、排他(独占)，自动删除的队列，并且获取名称
		String queueName = channel.queueDeclare().getQueue();
		//消息队列与交换器绑定，并且指定消费类型的数据
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
