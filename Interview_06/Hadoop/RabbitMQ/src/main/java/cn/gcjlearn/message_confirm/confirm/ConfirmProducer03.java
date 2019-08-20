package cn.gcjlearn.message_confirm.confirm;

import cn.gcjlearn.util.RabbitmqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author ：GongCJ
 * @date ：Created in 08-20-2019 17:33
 * @description：异步调用
 * @modified By：
 * @version: $
 */
public class ConfirmProducer03 {
	private static final String QUEUE_NAME = "test_confirm_queue";

	public static void main(String[] args) throws Exception {
		try (Connection connection = RabbitmqUtils.getConnection()) {
			try (Channel channel = connection.createChannel()) {
				//开启事务
				channel.confirmSelect();

				channel.queueDeclare(QUEUE_NAME, false, false, false, null);

				//未确认的消息标识
				final SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<Long>());

				//添加一个回调监听
				channel.addConfirmListener(new ConfirmListener() {
					//发送成功的
					@Override
					public void handleAck(long deliveryTag, boolean multiple) throws IOException {
						if (multiple) {
							confirmSet.remove(deliveryTag);
							System.out.println("消息发送成功");
						}else {
							handleNack(deliveryTag,multiple);
						}


					}

					//发送失败的
					@Override
					public void handleNack(long deliveryTag, boolean multiple) throws IOException {
						System.out.println("消息发送失败");
					}
				});

				//发送消息
				while (true) {
					long setNo = channel.getNextPublishSeqNo();
					channel.basicPublish("", QUEUE_NAME, null, "Hello!".getBytes());
					confirmSet.add(setNo);
					Thread.sleep(1000);
					System.out.println("发送完成");
				}
			}
		}
	}
}
