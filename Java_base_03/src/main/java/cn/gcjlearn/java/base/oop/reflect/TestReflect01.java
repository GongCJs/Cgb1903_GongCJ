package cn.gcjlearn.java.base.oop.reflect;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @author ：GongCJ
 * @date ：Created in 08-03-2019 9:07
 * @description：反射获取父类信息
 * @modified By：
 * @version: v1.01$
 */

interface TestReflect0101{

}

class TestReflectImpl010101 implements TestReflect0101{

}
class TestReflectImpl010102 implements TestReflect0101{

}

public class TestReflect01 {
	public static void main(String[] args) {
		for (Class aClass : ClassUtils.getAllClassByInterface(TestReflect0101.class)) {
			System.out.println(aClass.getName());
		}
	}
}