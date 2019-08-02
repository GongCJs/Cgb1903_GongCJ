package cn.gcjlearn.java.base.oop.features;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache02<K,V>{
	private LinkedHashMap<K,V> linkedHashMap;
	private Map<K,V> recycleMap = new HashMap<>();
 	public LRUCache02(Integer initialCapacity) {
		this.linkedHashMap
				= new LinkedHashMap<K,V>(initialCapacity,0.75F,true){
			@Override
			protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
				boolean flag = this.size() > initialCapacity;
				if (flag) {
					recycleMap.put(eldest.getKey(), eldest.getValue());
					this.remove(eldest.getKey());
				}
				return flag;
			}
		};
	}

	public void put(K key,V values){
		linkedHashMap.put(key,values);
	}
	public V get(K key){
 		return linkedHashMap.get(key);
	}
	//获取移除数据的集合
	public Map<K, V> getRecycle() {
		return recycleMap;
	}

	@Override
	public String toString() {
		return "LRUCache02{" +
				"linkedHashMap=" + linkedHashMap +
				'}';
	}
}

public class TestCompose02_LRU {
	public static void main(String[] args) {
		LRUCache02<String, Object> cache = new LRUCache02<>(3);
		cache.put("A", "AA");
		cache.put("B", "BB");
		cache.put("C", "CC");
		cache.put("D", "DD");
		System.out.println("缓存数据：" + cache);
		System.out.println("回收站数据：" + cache.getRecycle());
	}
}
