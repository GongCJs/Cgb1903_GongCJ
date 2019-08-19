package cn.gcjlearn.java.base.proxy.jdk.staticproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ：GongCJ
 * @date ：Created in 08-16-2019 17:10
 * @description：
 * @modified By：
 * @version: $
 */
public class ProxyHandler implements InvocationHandler {
	Object target;
	Interceptor interceptor;
	public ProxyHandler(Object target , Interceptor interceptor) {
		this.target = target;
		this.interceptor = interceptor;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Invocation invocation= new Invocation(target,method,args);
		interceptor.intercept(invocation);
		invocation.process();
		return null;
	}
}
