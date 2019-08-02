package cn.gcjlearn.java.base.oop.generic;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 将数字100插入到list集合中，利用反射
 * 将数字100 插入到list集合中的第0个位置
 */

public class TestGenneric09 implements Serializable {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		Class<? extends List> aClass = list.getClass();
		try {
			//getDeclaredMethod 获取任意访问修饰符的方法
			//getMethod 获取public访问修饰符的方法
			Method addMethod1 = aClass.getDeclaredMethod("add", Object.class);
			Method addMethod2 = aClass.getDeclaredMethod("add", int.class, Object.class);

			//调用list的add方法，参数为100
			//list 指定要运行谁的底层
			addMethod1.invoke(list,100);
			addMethod2.invoke(list,0,100);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println(list);
	}
}
