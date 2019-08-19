package cn.gcjlearn.java.base.proxy.jdk.staticproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author ：GongCJ
 * @date ：Created in 08-16-2019 17:28
 * @description：
 * @modified By：
 * @version: $
 */
public class ProxyFactory {
	private ProxyFactory() {
	}

	public static <T> T newProxy(Object target,Interceptor interceptor) {
		/**
		 * 1.获取目标类的类加载器
		 * 2.获取目标类的接口信息
		 * 3.创建ProxyHandler
		 */
		ClassLoader classLoader = target.getClass().getClassLoader();
		Class[] interfaces = target.getClass().getInterfaces();
		InvocationHandler invocationHandler = new ProxyHandler(target,interceptor);
		T t = (T) Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
		return t;
	}
}
