/*
package cn.gcjlearn.java.base.ClassLibrary;
import java.lang.ref.Cleaner;

class MyCleaner implements Runnable{
	public MyCleaner(){
		System.out.println("我是一个构造函数");

	}
	@Override
	public void run() {//销毁时运行的函数
		System.out.println("我是一个析构函数");
	}
}

class MyCleanerClear implements AutoCloseable{
	//创建一个清除处理
	private static final Cleaner cleaner = Cleaner.create();
	//指定需要一个清理的对象
	private MyCleaner myCleaner;
	private Cleaner.Cleanable cleanable;

	public MyCleanerClear(){
		//创建对象
		this.myCleaner = new MyCleaner();
		//注册利用当前对象，清理指定对象
		this.cleanable = cleaner.register(this, this.myCleaner);
	}
	@Override
	public void close() throws Exception {
		this.cleanable.clean();//启动多线程进行清理
	}
}

public class Gcj_Cleaner {
	public static void main(String[] args) {
		try(MyCleanerClear myCleanerClear = new MyCleanerClear()) {
			//编写逻辑代码
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	*/
/**
	 * 1.8
	 * @param args
	 *//*

	*/
/*
		public static void main(String[] args) {
			Gcj_Cleaner gs = new Gcj_Cleaner();
			gs = null;
			System.gc();
		}
		public Gcj_Cleaner(){
			System.out.println("我是一个构造函数");
		}
		@Override
		protected void finalize() throws Throwable {
			System.out.println("我是一个析构函数");
		}
	*//*

}
*/
