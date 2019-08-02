package cn.gcjlearn.java.base.ClassLibrary;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;

class Gcj_Cloneable0101 implements Cloneable{
	private String name;
	private Integer age;
	public Gcj_Cloneable0101(String name,Integer age){
		this.name = name;
		this.age = age;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return super.toString()+this.name+this.age;
	}
}

public class Gcj_Cloneable{
	public static void main(String[] args) throws CloneNotSupportedException {
		Gcj_Cloneable0101 gc1 = new Gcj_Cloneable0101("Gongcj",22);
		Gcj_Cloneable0101 gc2 = (Gcj_Cloneable0101)gc1.clone();
		System.out.println(gc1);
		System.out.println(gc2);
		System.out.println("ddddddddd");
		System.out.println("龚长江");
	}
}

