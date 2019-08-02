package cn.gcjlearn.java.base.ClassLibrary;

import java.util.Arrays;

public class Gcj_System {
	public static void main(String[] args) {
		Gcj_System gs = new Gcj_System();
		gs = null;
		System.gc();
	}
	public Gcj_System(){
		System.out.println("我是一个构造函数");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("我是一个析构函数");
	}
}
