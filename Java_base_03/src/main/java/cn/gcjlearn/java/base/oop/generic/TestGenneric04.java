package cn.gcjlearn.java.base.oop.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 手写线程安全的ArrayList
 * @param <E>
 */

class SynchronizedArrayList<E> extends ArrayList<E>{
	@Override
	public synchronized boolean add(E e) {
		return super.add(e);
	}

	@Override
	public synchronized E get(int index) {
		return super.get(index);
	}
}
public class TestGenneric04 {
	public static void main(String[] args) {

	}
}
