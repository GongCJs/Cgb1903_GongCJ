package cn.gcjlearn.java.base.oop.generic;

import java.util.ArrayList;
import java.util.List;

class ClassGenneric0801{
	public static <T extends Number> T MethodGenneric0801(T t){ //指定T的上界是Number，T必须是Number的子类
		return null;
	}
	public static <T> void MethodGenneric0802(List<? extends T> list){ //指定T的上界是Number，T必须是Number的子类
		System.out.println(list);
	}
}

public class TestGenneric08 {
	public static void main(String[] args) {
		List<Number> list = new ArrayList<>();
		list.add(30);
		list.add(30L);
		list.add(30.0);
		list.add(30.0F);
		ClassGenneric0801.MethodGenneric0802(list);
	}
}
