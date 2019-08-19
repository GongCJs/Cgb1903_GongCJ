package cn.gcjlearn.jvm.loader;

class ClassA {
	static {
		System.out.println("ClassA static");
	}
}

public class TestClassLoader02 {

	public static void main(String[] args) throws Exception {
		// 执行静态代码块
		//Class.forName("cgb.java.jvm.loader.ClassA");

		// 不执行静态代码块
		 ClassLoader loader=TestClassLoader02.class.getClassLoader();
		 //loader.loadClass("cgb.java.jvm.loader.ClassA");

		// false:不执行静态代码块
		 Class.forName("cgb.java.jvm.loader.ClassA", false, loader);
		System.out.println("end");
	}

}
