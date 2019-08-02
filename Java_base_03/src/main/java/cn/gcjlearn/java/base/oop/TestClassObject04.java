package cn.gcjlearn.java.base.oop;
import sun.reflect.Reflection;

class Class0401{
	static Integer count01 = 1000;
	static {
		System.out.println("Class0401：龚长江");
	}
}
class Class0402 extends  Class0401{
	static Integer count02 = 2000;
	static {
		System.out.println("Class0402：龚长江");
	}
}

/**
 * 测试getCallerClass方法
 */
class Class0403{
	static public void getCallerClass(int param){
		/**
		 * 0：返回sun.reflect.Reflection
		 * 1:返回当前类的Class对象
		 * 2：返回调用该方法的Class对象
		 */
		Class<?> aClass = Reflection.getCallerClass(param);
		System.out.println("Class0404：龚长江："+aClass);
	}
}


public class TestClassObject04 {
	
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		ClassLoader classLoader
				= ClassLoader.getSystemClassLoader();
		/*显示加载*/
//		classLoader.loadClass("cn.gcjlearn.java.base.oop.Class0401");

//		Class.forName("cn.gcjlearn.java.base.oop.Class0401");
//		Class.forName(
//				"cn.gcjlearn.java.base.oop.Class0402",
//				true,
//				classLoader);

		/*隐式加载*/
		/**
		 * 子类调用父类中的静态方法或者属性，之类属于被动加载，父类属于主动加载。
		 */
		Class0402 c = new Class0402();
		System.out.println(Class0402.count01);
	}
}
