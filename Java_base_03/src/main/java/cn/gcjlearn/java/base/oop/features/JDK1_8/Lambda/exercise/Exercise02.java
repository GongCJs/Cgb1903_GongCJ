package cn.gcjlearn.java.base.oop.features.JDK1_8.Lambda.exercise;

import cn.gcjlearn.java.base.oop.features.JDK1_8.Lambda.Data.Person;

import java.util.*;

public class Exercise02 {
	/**
	 * Set排序
	 * TreeSet<> TreeSet 会自动进行排序
	 */
	public static void main(String[] args) {
		//需求：在一个TreeSet中有若干个Person，我们需要根据Person的年龄进行降序排序
		Set<Person> set
				= new TreeSet<>((p1, p2) -> {
			if (p1.getAge()>p2.getAge()) {
				return 1;
			}else {
				return -1;
			}
		});
		for (int i = 0; i < 10; i++) {
			set.add(new Person("GongCJ" + i, new Random().nextInt(100)));
		}
		System.out.println(set);
	}
}
