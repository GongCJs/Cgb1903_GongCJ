package cn.gcjlearn.java.base.oop.features.JDK1_8.Lambda.exercise;

public class Exercise05 {
	/**
	 * 开辟一个线程
	 */
	public static void main(String[] args) {
		new Thread(() -> System.out.println("我是一个线程，我被启动了")).start();
	}
}
