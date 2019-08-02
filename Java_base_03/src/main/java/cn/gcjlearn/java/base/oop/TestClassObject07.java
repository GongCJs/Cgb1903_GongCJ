package cn.gcjlearn.java.base.oop;

/**
 * InnerClass0702不会被加载，因为没有创建或者引用类中的成员变量
 * 延迟加载
 */
class Class0701 {
	static Integer count = 100;

	static class InnerClass0702 {
		static {
			System.out.println("InnerClass0702");
		}
	}
}

public class TestClassObject07 {
	public static void main(String[] args) {
		System.out.println(Class0701.count);
	}
}
