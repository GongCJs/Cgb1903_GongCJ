package cn.gcjlearn.java.base.oop.features.JDK1_8.Lambda.Data;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Person{
	private String name;
	private Integer age;
	public Person(){
		System.out.println("我是Person类的无参构造函数");
	}
	public Person(String name,Integer age){
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
