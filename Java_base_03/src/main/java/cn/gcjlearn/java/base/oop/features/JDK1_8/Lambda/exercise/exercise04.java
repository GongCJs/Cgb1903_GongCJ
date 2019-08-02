package cn.gcjlearn.java.base.oop.features.JDK1_8.Lambda.exercise;

import cn.gcjlearn.java.base.oop.features.JDK1_8.Lambda.Data.Person;

import java.util.*;

public class exercise04 {
	public static void main(String[] args) {
		/**
		 * 删除集合中年纪小于等于50的person对象
		 */

		List<Person> list
				= new ArrayList<>();
		for (int i=0 ; i<10; i++){
			list.add(new Person("GongCJ"+i,new Random().nextInt(100)));
		}

		ListIterator<Person> personListIterator = list.listIterator();
		list.removeIf(p1->p1.getAge()<=50);
		list.forEach(System.out::println);
	}
}
