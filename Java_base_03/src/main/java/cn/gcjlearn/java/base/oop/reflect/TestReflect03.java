package cn.gcjlearn.java.base.oop.reflect;

import java.lang.reflect.Field;

/**
 * @author ：GongCJ
 * @date ：Created in 08-03-2019 15:12
 * @description：演示Declared区别
 * @modified By：
 * @version: $
 */

class TestReflect0301{
	public String param1;
	private String param2;
}
class TestReflect0302 extends TestReflect0301{
	public String param3;
	public String param4;
}

public class TestReflect03 {
	public static void main(String[] args) {
		Class<?> cla = TestReflect0302.class;
		for (Field declaredField : cla.getDeclaredFields()) {
			System.out.println(declaredField.getName());
		}
		/*
			输出结果：
				param3
				param4
		 */
		System.out.println("*************************");
		for (Field declaredField : cla.getFields()) {
			System.out.println(declaredField.getName());
		}

	}
}
