package cn.gcjlearn.java.base.oop.features.JDK1_8.Lambda.syntax;

import cn.gcjlearn.java.base.oop.features.JDK1_8.Lambda.interfaces.*;

public class Syntax02 {
	public static void main(String[] args) {
		/**
		 * 语法精简
		 * 1.参数类型：
		 * 		由于在接口中的抽象方法中，已经定义了参数类型、数量。所以在lambda表达式中，参数的类型可以省略
		 * 		备注：如果需要省略类型，则每一个参数都需要省略，不能出现一个省略另一个不省略的情况
		 *
		 */
		LambdaSingleReturnMutipleParameter lambda6 = (param1,param2) -> {
			System.out.println("我是一个有返回值多个参数的show方法"+param1+param2);
			return 6;
		};
		int show6 = lambda6.show(10,20);
		System.out.println("返回值为："+show6);

		/**
		 * 2.参数小括号
		 */
		LambdaSingleReturnSingleParameter lambda05
				= a ->{
			return a;
		};
		lambda05.show(10);
	}
}
