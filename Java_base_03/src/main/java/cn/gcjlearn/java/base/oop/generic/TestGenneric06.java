package cn.gcjlearn.java.base.oop.generic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Math{
	static <T extends Number> T max(T param1, T param2){
		Class<?> param1Class = param1.getClass();
		System.out.println(param1.equals(param2));
		return null;
	}
}

class ObjectFactory{
	public static <T> T newInstance(Class<T> cla) throws IllegalAccessException, InstantiationException {
		return (T)cla.newInstance();
	}

	public static <T> T newInstance(){
		return null;
	}
}

public class TestGenneric06 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		System.out.println(Math.max(30,20));
		Date date = ObjectFactory.newInstance(Date.class);
		System.out.println(date);

	}
}
