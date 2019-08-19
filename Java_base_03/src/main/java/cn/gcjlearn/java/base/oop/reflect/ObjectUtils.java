package cn.gcjlearn.java.base.oop.reflect;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

/**
 * @author ：GongCJ
 * @date ：Created in 08-03-2019 15:51
 * @description：构造、方法、属性赋值
 * @modified By：
 * @version: $
 */
public class ObjectUtils {
	private ObjectUtils(){};
	public static boolean setField(Object object,String fieldName,Object values){
		try {
			Class<?> cla = object.getClass();
			Field field = getField(cla,fieldName);
			checkValueTypeAndParamType(field.getType(),values.getClass());
			field.set(object,values);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean setField(Object object, Map info){
		Class<?> cla = object.getClass();
		Map.Entry entry = null;
		Field field = null;
		for (Iterator it = info.entrySet().iterator(); it.hasNext(); ) {
			entry = (Map.Entry)it.next();
			field = getField(cla,entry.getKey().toString());
			try {
				field.set(object,entry.getValue());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	//根据名称获取属性
	private static Field getField(Class<?> cla,String fieldName){
		Field field = null;

		try {
			field = cla.getDeclaredField(fieldName);

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		field.setAccessible(true);
		return field;
	}

	//判断传递值的类型和成员属性类型是否一致
	private static boolean checkValueTypeAndParamType(Class<?> paramType , Class<?> valueType ){
		if (paramType != valueType) {
			throw new IllegalArgumentException("参数类型不匹配");
		}
		return true;
	}

}
