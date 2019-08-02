package cn.gcjlearn.java.base.oop;

import java.util.HashMap;
import java.util.Map;

class Class0501 {
	static Class0501 instance = new Class0501();
	/**
	 * 1).报错修改方法，将pool 移动到instance之前
	 * 2).将pool修改为非静态，构造函数时，系统会先执行类中的语句，然后在进行构造
	 */
	static Map<String,Object> pool =
			new HashMap<>();

	public Class0501(){
		pool.put("A","100");
		pool.put("B","200");
	}
}

public class TestClassObject05 {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		classLoader.loadClass("cn.gcjlearn.java.base.oop.Class0501");

//		Class0501 class0501 = new Class0501();
		System.out.println(Class0501.pool);
	}
}
