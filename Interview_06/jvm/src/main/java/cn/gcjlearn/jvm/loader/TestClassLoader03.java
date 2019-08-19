package cn.gcjlearn.jvm.loader;
class A{
	public static int a=10;
	static {
		System.out.println("A.a="+a);
	}
}
class B extends A{
	static {
		System.out.println("B");
	}
}

public class TestClassLoader03 {
	public static void main(String[] args) {
		System.out.println(B.a);
	}
}

