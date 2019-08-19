package cn.gcjlearn.java.base.oop.reflect;

import javax.xml.ws.soap.MTOM;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

/**
 * @author ：GongCJ
 * @date ：Created in 08-03-2019 14:15
 * @description：获取类中方法的类型，名称，参数，异常信息
 * @modified By：
 * @version: $
 */
public class TestReflect02 {
	public static void main(String[] args) {
		Class<?> cla = ArrayList.class;

//		for (Method method : cla.getMethods()) {
		for (Method method : cla.getDeclaredMethods()) {
			//获取方法修饰类型
			System.out.print(Modifier.toString(method.getModifiers())+" ");
			//获取返回值类型
			System.out.print(method.getReturnType().getSimpleName()+" ");
			//获取方法名称
			System.out.print(method.getName()+"(");

			//获取参数列表
			Class<?>[] parameterTypes = method.getParameterTypes();
			for (int i = 0; i <parameterTypes.length; i++) {
				System.out.print("param-"+parameterTypes[i].getSimpleName());
				if (i!=parameterTypes.length-1) {
					System.out.print(",");
				}
			}
			System.out.println(")");
			//获取异常列表
			Class<?>[] exceptionTypes = method.getExceptionTypes();
			if (exceptionTypes.length !=0){
				System.out.print("throws");
				for (Class<?> exceptionType : exceptionTypes) {
					System.out.print(exceptionType.getSimpleName()+" ");
				}
			}
		}
	}
}
