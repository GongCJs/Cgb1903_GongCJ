package cn.gcjlearn.java.base.oop.binary_tree;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Person implements Serializable,Comparable<Person> {
	private String name;
	private Integer age;
	@Override
	public int compareTo(Person per) {
		return this.getAge()-per.getAge();
	}
}
