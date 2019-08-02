package cn.gcjlearn.java.base.oop.features;

final class DefaultMailService{
	public void sendMail(String msg){
		System.out.println("Send:"+msg);
	}
}
class LogDefaultMailService{
	private DefaultMailService defaultMailService;
	//线程单例
	public  LogDefaultMailService(){
		ThreadLocal<DefaultMailService> threadLocal
				= new ThreadLocal<DefaultMailService>(){
			@Override
			protected DefaultMailService initialValue() {
				return new DefaultMailService();
			}
		};
		defaultMailService = threadLocal.get();
	}

	public void sendMail(String msg){
		System.out.println(System.currentTimeMillis());
		defaultMailService.sendMail(msg);
		System.out.println(System.currentTimeMillis());
	}
}

/**
 * 组合
 */
public class TestCompose01 {
	public static void main(String[] args) {
		LogDefaultMailService logDefaultMailService
				= new LogDefaultMailService();
		logDefaultMailService.sendMail("我叫龚长江");
	}
}
