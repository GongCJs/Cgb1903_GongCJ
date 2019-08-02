package cn.gcjlearn.java.base.oop.generic;

interface MyMap<K,V>{
	V excute(K key);
}
class StringMap implements MyMap<String,Integer>{

	@Override
	public Integer excute(String key) {
		return Integer.parseInt(key);
	}


}

public class TestGenneric03 {
	public static void main(String[] args) {
		StringMap stringMap = new StringMap();
		System.out.println(stringMap.excute("100"));;
	}
}
