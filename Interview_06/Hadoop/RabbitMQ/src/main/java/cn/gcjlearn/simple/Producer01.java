package cn.gcjlearn.simple;

import cn.gcjlearn.util.RabbitmqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author ：GongCJ
 * @date ：Created in 08-19-2019 14:22
 * @description：
 * @modified By：
 * @version: $
 */
public class Producer01 {
	private static final String QUEUE_NAME = "test_simple_queue";

	public static void main(String[] args) throws Exception {
		try (Connection connection = RabbitmqUtils.getConnection()) {
			try (Channel channel = connection.createChannel()) {
				channel.queueDeclare(QUEUE_NAME, false, false, false, null);
				for (int i = 0; i < 10; i++) {
					channel.basicPublish("", QUEUE_NAME, null, "Hello!".getBytes());
					System.out.println("Send Successful");
				}
			}
		}
	}
}
