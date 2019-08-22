package cn.gcjlearn.java.high_concurrent_threadpool;

import java.util.concurrent.FutureTask;

/**
 * @author ：GongCJ
 * @date ：Created in 08-07-2019 10:52
 * @description：Thread构造函数介绍
 * @modified By：
 * @version: $
 */
public class TestThread02 {
	public static void main(String[] args) {
		System.out.println("【Main+"+Thread.currentThread().getThreadGroup().getName()+"】");
		Thread thread = new Thread();
		thread.start();
		System.out.println("【Thread+"+thread.getThreadGroup().getName()+"】");
	}
}
