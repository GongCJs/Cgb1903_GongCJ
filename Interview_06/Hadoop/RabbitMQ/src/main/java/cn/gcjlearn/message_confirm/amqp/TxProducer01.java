package cn.gcjlearn.message_confirm.amqp;

import cn.gcjlearn.util.RabbitmqUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author ：GongCJ
 * @date ：Created in 08-20-2019 17:33
 * @description：
 * @modified By：
 * @version: $
 */
public class TxProducer01 {
	private static final String QUEUE_NAME = "test_tx_queue";

	public static void main(String[] args) throws Exception {
		try (Connection connection = RabbitmqUtils.getConnection()) {
			try (Channel channel = connection.createChannel()) {
				channel.queueDeclare(QUEUE_NAME, false, false, false, null);
				//开启事务
				channel.txSelect();
				for (int i = 0; i < 10; i++) {
					channel.basicPublish("", QUEUE_NAME, null, "Hello!".getBytes());
					System.out.println("Send Successful");
					//提交事务
					channel.txCommit();
					//回滚事务
					//channel.txRollback();
				}
			}
		}
	}
}
