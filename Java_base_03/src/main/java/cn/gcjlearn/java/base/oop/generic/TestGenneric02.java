package cn.gcjlearn.java.base.oop.generic;

import java.util.ArrayList;
import java.util.List;

interface Container<T>{
	void add(T t);
	T get(int i);
}
class ArrayContainner<T> implements Container<T>{

	@Override
	public void add(T o) {

	}

	@Override
	public T get(int i) {
		return null;
	}
}

public class TestGenneric02 {
	public static void main(String[] args) {

	}
}
