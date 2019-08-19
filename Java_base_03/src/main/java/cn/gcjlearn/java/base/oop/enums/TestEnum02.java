package cn.gcjlearn.java.base.oop.enums;

import java.util.Arrays;

/**
 * @author ：GongCJ
 * @date ：Created in 08-13-2019 8:49
 * @description：枚举
 * @modified By：
 * @version: $
 */
enum TestEnum0201{
	MALE("男"),FEMALE("女"),NONE("未知");
	String name;
	TestEnum0201(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
}


/**
 * @author Gongcj
 */
public class TestEnum02 {
	public static void main(String[] args) {
		System.out.println(TestEnum0201.NONE.getName());;
	}
}
