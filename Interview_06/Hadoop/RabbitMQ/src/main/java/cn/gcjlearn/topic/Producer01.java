package cn.gcjlearn.topic;

import cn.gcjlearn.util.RabbitmqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.util.Random;

/**
 * @author ：GongCJ
 * @date ：Created in 08-20-2019 10:09
 * @description：
 * @modified By：
 * @version: $
 */
public class Producer01 {
	private static final String EXCHANGE_NAME = "test_topic_exchange";
	private static final String EXCHANGE_TYPE = "topic";

	public static void main(String[] args) throws Exception {
		try (Connection connection = RabbitmqUtils.getConnection()) {
			try (Channel channel = connection.createChannel()) {
				channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);
				for (int i = 0; i < 10; i++) {
					//获取路由键
					String routingKey = getInto();
					int sleep = new Random().nextInt(3) + 1;
					String msg = ("ID:" + i + " routingKey:" + routingKey + "  Hello!" + sleep);
					channel.basicPublish(EXCHANGE_NAME, routingKey, null, msg.getBytes());
					System.out.println(msg);
				}
			}
		}

	}

	//随机生成一个路由键
	private static String getInto() {
		String[] types = {"info.orange.info", "warning.info.rabbit", "lazy.info", "lazy", "a.b.rabbit", "a.orange.a"};
		return types[new Random().nextInt(types.length)];
	}
}
