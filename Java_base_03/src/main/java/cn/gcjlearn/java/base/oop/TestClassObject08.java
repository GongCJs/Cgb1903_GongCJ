package cn.gcjlearn.java.base.oop;

class Class0801{
	static Class0801 instance = new Class0801();

	{
		System.out.println("ddd");
	}

	public Class0801(){
		System.out.println("Class0801");
	}
	static {
		System.out.println("static");
	}
}


public class TestClassObject08 {
	public static void main(String[] args) throws ClassNotFoundException {
		Class0801 class0801 = Class0801.instance;
	}
}
