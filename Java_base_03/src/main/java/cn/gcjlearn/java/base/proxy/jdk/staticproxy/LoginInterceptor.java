package cn.gcjlearn.java.base.proxy.jdk.staticproxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ：GongCJ
 * @date ：Created in 08-16-2019 19:30
 * @description：
 * @modified By：
 * @version: $
 */
public class LoginInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) {
		System.out.println("打印日志");
		return null;
	}
}
