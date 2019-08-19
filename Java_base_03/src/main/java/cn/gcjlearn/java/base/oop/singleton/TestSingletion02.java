package cn.gcjlearn.java.base.oop.singleton;


/**
 * @author ：GongCJ
 * @date ：Created in 08-09-2019 9:29
 * @description：ThreadLocal测试
 * @modified By：
 * @version: $
 */

class ThreadLocalUtils {
	private ThreadLocalUtils() {}
	private static ThreadLocal threadLocal = null;
	public static ThreadLocal<Object> getThreadLocal() {
		if (threadLocal == null) {
			synchronized (ThreadLocalUtils.class) {
				if (threadLocal == null) {
					threadLocal = new ThreadLocal<Object>();
				}
			}
		}
		return threadLocal;
	}
}


/**
 * @author Gongcj
 */
public class TestSingletion02 {
	public static void main(String[] args) {
		int i = 0;
		while (i <= 10) {
			new Thread(() -> {
				try {
					Thread.sleep(1000);
					ThreadLocalUtils.getThreadLocal().set("我是："+Thread.currentThread().getName());
					System.out.println(ThreadLocalUtils.getThreadLocal().get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}, ""+i).start();
			i++;
		}
	}
}
