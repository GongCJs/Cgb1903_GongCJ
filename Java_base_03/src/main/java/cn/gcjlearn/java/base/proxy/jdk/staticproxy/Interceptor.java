package cn.gcjlearn.java.base.proxy.jdk.staticproxy;

public interface Interceptor {
	//执行扩展功能
	public Object intercept(Invocation invocation);
}
