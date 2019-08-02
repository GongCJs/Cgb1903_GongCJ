package cn.gcjlearn.java.base.jvm;

import java.util.ArrayList;
import java.util.List;

public class TestMemory02 {
	//栈内存益处
	static void doMethod(){
		doMethod();
	}


	public static void main(String[] args) {

		/**
		 *
		 *  	-vmargs		//虚拟机设置
		 *      -Xms40m		//初始内存
		 *      -Xmx256m	//最大内存
		 *      -Xmn16m		//最小内存
		 *      -XX:PermSize=128M 	//非堆内存
		 *      -XX:MaxPermSize=256M
		 *
		 */
//		doMethod();

		//获取方法栈中的方法
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		for (StackTraceElement stackTraceElement : stackTrace){
			System.out.println(stackTraceElement.getMethodName());
		}

	}
}
