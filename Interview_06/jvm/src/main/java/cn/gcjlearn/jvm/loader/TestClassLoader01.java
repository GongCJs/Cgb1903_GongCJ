package cn.gcjlearn.jvm.loader;

public class TestClassLoader01 {

	public static void main(String[] args) throws Exception {
		System.out.println("classloader of object " + Object.class.getClassLoader());

		ClassLoader loader = TestClassLoader01.class.getClassLoader();
		System.out.println(loader);
		System.out.println(loader.getParent());
		System.out.println(loader.getParent().getParent());
	}

}
