package cn.gcjlearn.jvm.tools;

public class DeadLock {
	public static String objA = "objA";
	public static String objB = "objB";

	public static void main(String[] args) {

		// 单独运行两个线程都不会产生死锁
		Thread threadA = new Thread(new ThreadA());
		threadA.start();

		Thread threadB = new Thread(new ThreadB());
		threadB.start();
	}
}

class ThreadA implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("ThreadA running");
			while (true) {
				synchronized (DeadLock.objA) {
					System.out.println("ThreadA lock objA");
					Thread.sleep(3000);// 获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2
					synchronized (DeadLock.objB) {
						System.out.println("ThreadA lock objB");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class ThreadB implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("ThreadB running");
			while (true) {
				synchronized (DeadLock.objB) {
					System.out.println("ThreadB lock objB");
					Thread.sleep(3000);
					synchronized (DeadLock.objA) {
						System.out.println("ThreadB lock objA");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
