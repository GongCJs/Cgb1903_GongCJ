package cn.gcjlearn.java.base.oop.enums;

import java.util.Arrays;

/**
 * @author ：GongCJ
 * @date ：Created in 08-13-2019 8:49
 * @description：枚举
 * @modified By：
 * @version: $
 */
enum TestEnum0101{
	MALE,FEMALE,NONE;
}


/**
 * @author Gongcj
 */
public class TestEnum01 {
	public static void main(String[] args) {
		TestEnum0101[] testEnum0101s 
				= TestEnum0101.values();
		System.out.println(Arrays.toString(testEnum0101s));
	}
}
