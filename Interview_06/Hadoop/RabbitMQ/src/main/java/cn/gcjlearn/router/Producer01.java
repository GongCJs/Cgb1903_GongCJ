package cn.gcjlearn.router;

import cn.gcjlearn.util.RabbitmqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.util.Random;

/**
 * @author ：GongCJ
 * @date ：Created in 08-19-2019 19:51
 * @description：
 * @modified By：
 * @version: $
 */
public class Producer01 {
	private static final String EXCHANGE_NAME = "test_router_exchange";
	//指定交换器类型，在使用路由器的模式下必须使用“direct”类型的交换器
	private static final String EXCHANGE_TYPE = "direct";

	public static void main(String[] args) throws Exception {
		try (Connection connection = RabbitmqUtils.getConnection()) {
			try (Channel channel = connection.createChannel()) {
				//声明一个交换器
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
		String[] types = {"error", "warning", "info"};
		return types[new Random().nextInt(types.length)];
	}
}
