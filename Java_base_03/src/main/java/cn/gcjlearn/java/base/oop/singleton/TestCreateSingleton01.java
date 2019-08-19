package cn.gcjlearn.java.base.oop.singleton;

/**
 * @author GongCJ
 * 懒汉式单例设计模式
 */
class  LazySingleton{
	static {
		System.out.println("Static");
	}
	private static volatile LazySingleton lazySingleton = null;
	private static String LOCK = "LOCK";
	private LazySingleton(){
		System.out.println("****"+Thread.currentThread().getName()+"、懒汉式单例设计模式****");
	};

	public static LazySingleton getInstance(){
		if (lazySingleton == null){
			synchronized (LOCK){
				if (lazySingleton == null) {
					lazySingleton = new LazySingleton();
				}
			}
		}
		return lazySingleton;
	}
}

/**
 * @author GongCJ
 * create by: GongCJ
 * description: TODO
 * create time:
 * @return
 */
public class TestCreateSingleton01 {
	public static void main(String[] args) throws ClassNotFoundException {
//		for (int i = 0; i <3 ; i++) {
//			new Thread(() -> {
//				LazySingleton.getInstance();
//			},"懒汉式加载"+i).start();
//		};
	};
}
