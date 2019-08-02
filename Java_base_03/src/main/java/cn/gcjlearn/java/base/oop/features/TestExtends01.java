package cn.gcjlearn.java.base.oop.features;

/**
 * 定义一个搜素业务对象
 */
class DefaultSearchService0101{
	public Object search(String key){
		System.out.println("Search ..");
		return "Search result by " + key;
	}
}
/*
	新需求：不修改DefaultSearchService类的情况下，实现对search方法进行日志记录
 */
class LogDefaultSearchService0102 extends DefaultSearchService0101{
	@Override
	public Object search(String key) {
		System.out.println(System.nanoTime());
		Object result = super.search(key);
		System.out.println(System.nanoTime());
		return result;
	}
}

public class TestExtends01 {
	public static void main(String[] args) {
		DefaultSearchService0101 ds = new LogDefaultSearchService0102();
		ds.search("我开始搜索了");
	}
}
