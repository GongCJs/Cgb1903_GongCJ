package cn.gcjlearn.java.base.oop.reflect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：GongCJ
 * @date ：Created in 08-03-2019 15:49
 * @description：给成员设置值
 * @modified By：
 * @version: $
 */

class TestReflect0401 {
	private String param1;
	private String param2;
	private String param3;
	private String param4;
	private String param5;
	private String param6;
	private Integer param7;
	private Integer param8;

	@Override
	public String toString() {
		return "TestReflect0401{" +
				"param1='" + param1 + '\'' +
				", param2='" + param2 + '\'' +
				", param3='" + param3 + '\'' +
				", param4='" + param4 + '\'' +
				", param5='" + param5 + '\'' +
				", param6='" + param6 + '\'' +
				", param7='" + param7 + '\'' +
				", param8='" + param8 + '\'' +
				'}';
	}
}

public class TestReflect04 {
	public static void main(String[] args) {
		TestReflect0401 testReflect0401 = new TestReflect0401();
//		ObjectUtils.setField(testReflect0401,"param1","这是我的第一个参数");
//		ObjectUtils.setField(testReflect0401,"param2","这是我的第一个参数");
//		ObjectUtils.setField(testReflect0401,"param3","这是我的第一个参数");
//		ObjectUtils.setField(testReflect0401,"param4","这是我的第一个参数");
//		ObjectUtils.setField(testReflect0401,"param5","这是我的第一个参数");
//		ObjectUtils.setField(testReflect0401,"param6","这是我的第一个参数");
//		ObjectUtils.setField(testReflect0401,"param7",120);
//		ObjectUtils.setField(testReflect0401,"param8",130);

		Map<String,Object> maps = new HashMap<>();
		maps.put("param1","这是我的第一个参数");
		maps.put("param2","这是我的第一个参数");
		maps.put("param3","这是我的第一个参数");
		maps.put("param4","这是我的第一个参数");
		maps.put("param5","这是我的第一个参数");
		maps.put("param6","这是我的第一个参数");
		maps.put("param7",120);
		maps.put("param8",130);
		ObjectUtils.setField(testReflect0401,maps);
		System.out.println(testReflect0401);
	}
}
