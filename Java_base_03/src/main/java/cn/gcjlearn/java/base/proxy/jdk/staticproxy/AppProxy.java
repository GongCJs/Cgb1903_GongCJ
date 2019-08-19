package cn.gcjlearn.java.base.proxy.jdk.staticproxy;

/**
 * @author ：GongCJ
 * @date ：Created in 08-16-2019 17:34
 * @description：
 * @modified By：
 * @version: $
 */
public class AppProxy {
	public static void main(String[] args) {
		Executor target = new DefaultExecutor();
		Interceptor interceptor = new LoginInterceptor();
		Executor executor = ProxyFactory.newProxy(target,interceptor);
		executor.execute();
	}
}
