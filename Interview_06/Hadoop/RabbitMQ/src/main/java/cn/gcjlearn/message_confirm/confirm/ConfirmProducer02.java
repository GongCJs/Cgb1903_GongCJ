package cn.gcjlearn.message_confirm.confirm;

import cn.gcjlearn.util.RabbitmqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author ：GongCJ
 * @date ：Created in 08-20-2019 17:33
 * @description：批量同步调用
 * @modified By：
 * @version: $
 */
public class ConfirmProducer02 {
	private static final String QUEUE_NAME = "test_confirm_queue";

	public static void main(String[] args) throws Exception {
		try (Connection connection = RabbitmqUtils.getConnection()) {
			try (Channel channel = connection.createChannel()) {
				channel.queueDeclare(QUEUE_NAME, false, false, false, null);
				channel.confirmSelect();
				for (int i = 0; i < 10; i++) {
					channel.basicPublish("", QUEUE_NAME, null, "Hello!".getBytes());
				}
				if (channel.waitForConfirms()) {
					System.out.println("发送成功");
				} else {
					System.out.println("发送失败");
				}
			}
		}
	}
}
