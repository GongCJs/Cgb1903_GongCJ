package cn.gcjlearn.java.base.classloader;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * @author ：GongCJ
 * @date ：Created in 08-02-2019 19:17
 * @description：利用字节码对象生成一个类
 * @modified By：
 * @version: v1.01$
 */

public class NewClass {
	public static void main(String[] args) throws Exception {
		Class<?> cla = Aaa.class;
		Object object = cla.getDeclaredConstructor(String.class).newInstance("我的");
		System.out.println(object.toString());
	}
}
class Aaa{
	public Aaa(){}
	public Aaa(String name){
		System.out.println("你传入的信息为："+name);
	}
	@Override
	public String toString() {
		return "Aaa{}";
	}
};