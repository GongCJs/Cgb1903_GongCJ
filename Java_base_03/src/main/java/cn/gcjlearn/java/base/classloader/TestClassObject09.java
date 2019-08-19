package cn.gcjlearn.java.base.classloader;

class Class0901{
	/**
	 * 当类中含有static final 修饰的基本数据类型和字符串类型时，
	 * 就会在编译阶段执行初始化。所以调用类中static final修饰的变量时不会初始化类
	 */
	public static final int count = 190;
	public static final String LOCK ="GongCJ";
	static {
		System.out.println("static{}");
	}
}

public class TestClassObject09 {
	public static void main(String[] args) {
		System.out.println(Class0901.LOCK);
	}
}
