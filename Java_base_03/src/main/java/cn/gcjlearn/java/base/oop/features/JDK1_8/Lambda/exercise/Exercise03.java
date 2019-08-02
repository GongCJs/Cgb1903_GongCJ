package cn.gcjlearn.java.base.oop.features.JDK1_8.Lambda.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise03 {
	/**
	 * 遍历集合
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list
				= new ArrayList<>();
		Collections.addAll(list,1,2,3,4,5,6,7,8,9,10);
		//输出所有数据 利用lambda的方法引用
		list.forEach(System.out::println);
		//输出所有的数据 利用lambda的表达式方式
		list.forEach(p1->System.out.println(p1));
		//输出寄数数据
		list.forEach(p1->{
			if (p1%2==1) {
				System.out.println(p1);
			}
		});
	}
}
