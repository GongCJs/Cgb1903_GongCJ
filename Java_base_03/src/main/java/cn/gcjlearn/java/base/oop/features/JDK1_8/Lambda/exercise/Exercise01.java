package cn.gcjlearn.java.base.oop.features.JDK1_8.Lambda.exercise;

import cn.gcjlearn.java.base.oop.features.JDK1_8.Lambda.Data.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Exercise01 {
	/**
	 * 集合排序
	 * ArrayList<>
	 */
	public static void main(String[] args) {
		//需求：在一个ArrayList中有若干个Person，我们需要根据Person的年龄进行降序排序
		List<Person> list 
				= new ArrayList<>();
		for (int i=0 ; i<10; i++){
			list.add(new Person("GongCJ"+i,new Random().nextInt(100)));
		}

		list.sort((p1,p2)->p2.getAge()-p1.getAge());
		System.out.println(list);
	}
}
