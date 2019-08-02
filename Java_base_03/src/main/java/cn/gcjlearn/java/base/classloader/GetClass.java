package cn.gcjlearn.java.base.classloader;


import org.junit.Test;

public class GetClass {
	@Test
	public void TestClassLoader() throws ClassNotFoundException {
		/**
		 * 常用类加载的3种方式
		 */
		Class<Object> cla1 = Object.class;
		Class<?> cla2 = new Object().getClass();
		Class<?> cla3 = Class.forName("java.lang.Object");
		System.out.println(cla1 == cla2);
		System.out.println(cla2 == cla3);
		System.out.println(cla1 == cla3);

		//获取类的加载加载器对象
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		//通过类加载器加载对象
		Class<?> cla4 = classLoader.loadClass("java.lang.Object");
		
		System.out.println(cla4 == cla1);
	}
}
