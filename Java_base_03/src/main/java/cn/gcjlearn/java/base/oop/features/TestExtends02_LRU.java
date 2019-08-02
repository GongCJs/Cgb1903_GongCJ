package cn.gcjlearn.java.base.oop.features;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
	Integer maxCap;
	//移除的数据
	private Map<K, V> recycleMap = new HashMap<>();

	public LRUCache(Integer initialCapacity,
					Float loadFactor,
					Boolean accessOrder) {
		//调用父类的有参构造
		super(initialCapacity, loadFactor, accessOrder);
		this.maxCap = initialCapacity;
	}

	//重写父类方法的移除最老方法
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		boolean flag = this.size() > this.maxCap;
		if (flag) {
			recycleMap.put(eldest.getKey(), eldest.getValue());
			this.remove(eldest.getKey());
		}
		return flag;
	}

	//获取移除数据的集合
	public Map<K, V> getRecycle() {
		return recycleMap;
	}
}

/**
 * LinkedHashMap
 * 1.记录元素添加顺序
 * 2.记录元素访问顺序
 */
public class TestExtends02_LRU {
	public static void main(String[] args) {
		LRUCache<String, Object> cache = new LRUCache<>(3, 0.75F, true);
		cache.put("A", "AA");
		cache.put("B", "BB");
		cache.put("C", "CC");
		cache.get("A");
		cache.put("D", "DD");
		System.out.println("缓存数据：" + cache);
		System.out.println("回收站数据：" + cache.getRecycle());
	}
}
