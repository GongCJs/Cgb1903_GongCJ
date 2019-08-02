package cn.gcjlearn.java.base.oop;

/**
 *  类何时被加载？
 *  1.隐式加载
 *   a)构建类的实例对象
 *   b)访问类的静态成员（属性，方法）
 *  2.显式加载
 *	 a)Class.forName(...)
 *	 b)loader.load(...)
 */
class Class0201{
	static final Integer content = 100;
	static void  doMethod(){}
}

public class TestClassObject02 {
	public static void main(String[] args) throws ClassNotFoundException {
		//不会加载类
		Class0201 a;

		//加载类中的属性，类会被加载
//		Integer content = A.content;
		//加载类中的方法，类会被加载

		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		classLoader.loadClass("cn.gcjlearn.java.base.oop.A");

	}
}
