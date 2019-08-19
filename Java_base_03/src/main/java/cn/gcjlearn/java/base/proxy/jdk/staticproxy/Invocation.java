package cn.gcjlearn.java.base.proxy.jdk.staticproxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ：GongCJ
 * @date ：Created in 08-16-2019 19:45
 * @description：封装目标方法
 * @modified By：
 * @version: $
 */
public class Invocation {
	Object target;
	Method method;
	Object[] args;

	public Invocation(Object target, Method method, Object[] args) {
		this.target = target;
		this.method = method;
		this.args = args;
	}
	//执行目标方法
	public Object process(){
		try {
			method.invoke(target,args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
