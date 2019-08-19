package cn.gcjlearn.java.high_concurrent_threadpool;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：GongCJ
 * @date ：Created in 08-07-2019 10:52
 * @description：主线程中处理子线程中的异常信息
 * @modified By：
 * @version: $
 */
public class TestThread01 {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			Integer i = 0;
			while (true) {
				System.out.println(Thread.currentThread().getName() + "：" + i++);
				if (i == 5) {
					System.out.println(1 / 0);
				}
			}
		});
		//全局异常处理信息
		Thread.UncaughtExceptionHandler currentException = new Thread.UncaughtExceptionHandler(){
			@Override
			public void uncaughtException(Thread thread, Throwable throwable) {
				System.out.println("【线程名称：" + thread.getName() + "】【线程标识：" + thread.getId() + "】");
				System.out.println("【异常信息：" + throwable.getMessage() + "】");
			}
		};
		//指定线程处理信息
		t1.setUncaughtExceptionHandler((thread, throwable) -> {
			System.out.println("【线程名称：" + thread.getName() + "】【线程标识：" + thread.getId() + "】");
			System.out.println("【异常信息：" + throwable.getMessage() + "】");
		});

		AtomicInteger atomicInteger = new AtomicInteger();
		atomicInteger.incrementAndGet();
		Thread.setDefaultUncaughtExceptionHandler(currentException);

		t1.start();
	}
}
