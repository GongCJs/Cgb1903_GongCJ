package cn.gcjlearn.java.base.oop;

/**
 * @author Gongcj
 * 类加载器
 */
public class TestClassObject03 {
	public static void main(String[] args) {
		//获取AppClassLoader
		ClassLoader loader01 = ClassLoader.getSystemClassLoader();
		//获取ExtClassLoader
		ClassLoader loader02 = loader01.getParent();
		//获取BootstrapClassLoader
		ClassLoader loader03 = loader02.getParent();
		System.out.println(loader01);
		System.out.println(loader02);
		System.out.println(loader03);
	}
}
