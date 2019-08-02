package cn.gcjlearn.java.base.ClassLibrary;

import java.util.Optional;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

class MessageUtil {
	private MessageUtil() {
	}

	;
	private MessageUtil messageUtil;

	public static Optional<IMessage> getMessage() {
		return Optional.ofNullable(null);
	}

	public static void userMessage(IMessage msg) {
		//有可能为空
		if (msg != null) {
			System.out.println(msg.getContent());
		}
	}
}

class MessageImpl implements IMessage {
	@Override
	public String getContent() {
		return "www.gcjlearn.cn";
	}
}

interface IMessage {
	public String getContent();
}

public class Gcj_Optional {
	public static void main(String[] args) {
		IMessage iMessage = MessageUtil.getMessage().orElse(new MessageImpl());
		MessageUtil.userMessage(iMessage);
	}
}
