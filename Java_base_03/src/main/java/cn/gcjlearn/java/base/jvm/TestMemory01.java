package cn.gcjlearn.java.base.jvm;

import java.util.ArrayList;
import java.util.List;

public class TestMemory01 {
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

		//堆内存益处
		List<Byte[]> list = new ArrayList<>();
		for (int i=0; i<10; i++){
			list.add(new Byte[1024*1024]);
		}
	}
}
