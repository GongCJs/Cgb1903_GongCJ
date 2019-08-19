package cn.gcjlearn.jvm.tools;

import java.util.ArrayList;

public class TestMAT {
	public static ArrayList<UserEntity> userEntities = new ArrayList<>();
	public static ArrayList<byte[]> data = new ArrayList<>();
	public static ArrayList<Thread> threads = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("testMAT");
		MyBitmap myBitmap = new MyBitmap();
		for (int i = 0; i < 100000; i++) {
			UserEntity userEntity = new UserEntity();
			userEntities.add(userEntity);
		}
		while (true) {

			try {
				data.add(new byte[1024 * 1024]);
				Mythread mythread = new Mythread();
				mythread.start();
				threads.add(mythread);
				Thread.currentThread().sleep(1000 * 10);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class Mythread extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println(getName());
		}
	}
}
