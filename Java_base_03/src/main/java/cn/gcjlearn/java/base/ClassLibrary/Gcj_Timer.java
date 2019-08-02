package cn.gcjlearn.java.base.ClassLibrary;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.FutureTask;

public class Gcj_Timer{
	public static void main(String[] args) {
		//在一个线程中每隔1s打印异常Hello World！，打印100次后退出
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			Integer num = 100;
			@Override
			public void run() {
				if (num>=0){
					System.out.println("Hello World!"+num);
					num --;
				}else {
					timer.cancel();
				}
			}
		}, 0L,100L);
	}
}
