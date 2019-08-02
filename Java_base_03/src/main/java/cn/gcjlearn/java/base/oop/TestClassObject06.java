package cn.gcjlearn.java.base.oop;

import java.util.Date;

class ObjectFactory{
	public static <T extends Object> T newInstance(Class<T> cla) throws IllegalAccessException, InstantiationException {
		return (T) cla.newInstance();
	}
	public static <T extends Object> T newInstance(String className) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
		Class<?> aClass = Class.forName(className);
		return (T) aClass.newInstance();
	}
}

public class TestClassObject06 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Date date =
				ObjectFactory.newInstance(Date.class);

		Date date1 = ObjectFactory.newInstance("java.util.Date");
		System.out.println(date1);
	}
}
