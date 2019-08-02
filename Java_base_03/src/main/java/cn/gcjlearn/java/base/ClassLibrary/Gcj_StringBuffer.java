package cn.gcjlearn.java.base.ClassLibrary;

import java.util.Comparator;

public class Gcj_StringBuffer {
	public static void main(String[] args) {
		String s1 = "Gong";
		change(s1);
		System.out.println(s1);
		
		StringBuffer s2 = new StringBuffer("Gong");
		s2.delete(1,2);
//		change(s2);
		System.out.println(s2);
	}
	//传递的是s1对象的引用地址
	private static void change(String string){
		string += "is Change";
	}

	private static  void change(StringBuffer stringBuffer){
		stringBuffer.append("is change");
	}
}
