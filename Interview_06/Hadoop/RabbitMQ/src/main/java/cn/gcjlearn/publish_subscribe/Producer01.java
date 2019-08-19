package cn.gcjlearn.publish_subscribe;

import cn.gcjlearn.util.RabbitmqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.util.Random;

/**
 * @author ：GongCJ
 * @date ：Created in 08-19-2019 14:22
 * @description：
 * @modified By：
 * @version: $
 */
public class Producer01 {
	private static final String EXCHANGE_NAME = "test_publish_subscribe_exchange";
	private static final String EXCHANGE_TYPE = "fanout";

	public static void main(String[] args) throws Exception {
		try (Connection connection = RabbitmqUtils.getConnection()) {
			try (Channel channel = connection.createChannel()) {
				channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);
				for (int i = 0; i < 10; i++) {
					int sleep = new Random().nextInt(3) + 1;
					String msg = ("ID:" + i + "  Hello!" + sleep);
					channel.basicPublish(EXCHANGE_NAME, "", null, msg.getBytes());
					System.out.println(msg);
				}
			}
		}
	}
}
