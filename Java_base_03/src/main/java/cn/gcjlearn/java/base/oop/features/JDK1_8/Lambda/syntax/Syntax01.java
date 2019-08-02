package cn.gcjlearn.java.base.oop.features.JDK1_8.Lambda.syntax;

import cn.gcjlearn.java.base.oop.features.JDK1_8.Lambda.interfaces.*;

public class Syntax01 {
	public static void main(String[] args) {
		/**
		 * 
		 */
		//无返回、无参函数
		LambdaNoneReturnNoneParameter lambda1 = ()->{
			System.out.println("我是一个无返回值无参的show方法");
		};
		lambda1.show();

		//无返回、一个参数
		LambdaNoneReturnSingleParameter lambda2 = (param1) ->{
			System.out.println("我是一个无返回值一个参数的show方法"+param1*2);
		};
		lambda2.show(20);

		//无返回、多个参数
		LambdaNoneReturnMutipleParameter lambda3 = (param1,param2) -> {
			System.out.println("我是一个无返回值多个个参数的show方法"+param1*param2);
		};
		lambda3.show(20,20);


		//有返回、无参函数
		LambdaSingleReturnNoneParameter lambda4 = () -> {
			System.out.println("我是一个有返回值无参的show方法");
			return 4;
		};
		int show4 = lambda4.show();
		System.out.println("返回值为："+show4);

		//有返回、无参函数
		LambdaSingleReturnSingleParameter lambda5 = (param1) -> {
			System.out.println("我是一个有返回值有一个参数show方法"+param1);
			return 5;
		};
		int show5 = lambda5.show(5);
		System.out.println("返回值为："+show5);

		//有返回、无参函数
		LambdaSingleReturnMutipleParameter lambda6 = (param1,param2) -> {
			System.out.println("我是一个有返回值多个参数的show方法"+param1+param2);
			return 6;
		};
		int show6 = lambda6.show(10,20);
		System.out.println("返回值为："+show6);
	}
}
