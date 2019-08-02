package cn.gcjlearn.java.base.oop.features.JDK1_8.Lambda.syntax;

import cn.gcjlearn.java.base.oop.features.JDK1_8.Lambda.interfaces.LambdaSingleReturnSingleParameter;

public class Syntax03 {
	public static void main(String[] args) {
		/**
		 * 方法因引用
		 * 可以快速的将一个Lambda表达式的实现指向一个已经实现的方法上
		 * 语法：方法的隶属者::方法名称
		 * 注意：
		 * 		1.参数的数量和类型一定要和接口中定义的方法一致
		 * 		2.返回值类型一定要和接口中定义的方法一致
		 */
		LambdaSingleReturnSingleParameter lambda01
				=Syntax03::change;

		int show = lambda01.show(10);
		System.out.println(show);
	}

	public static int change(int p1){
		return p1*1000;
	}
}
