package cn.gcjlearn.java.base.ClassLibrary;

public class Gcj_Runtime {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		//获取内核数
		System.out.println(runtime.availableProcessors());
		//获取最大可用内存空间
		System.out.println(runtime.maxMemory());
		//获取可用内存空间
		System.out.println(runtime.totalMemory());
		//获取空闲内存空间
		System.out.println(runtime.freeMemory());
		//手工进行GC处理
		runtime.gc();

	}
}
