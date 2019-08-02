package cn.gcjlearn.java.base.oop.generic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class DefaultSqlSession {
	public <T> T getMapper(Class<T> cla) {
		return (T) cla.getInterfaces();
	}
}

class CollectionUtil {
	static <T> List<T> convert(List<T> list) {
		return null;
	}

	static <T> void print(List<T> list) {
		System.out.println(list);
	}

}

class DateUtils {
	static <T extends Date> T toDate(String data, String type) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
		try {
			return (T) simpleDateFormat.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("类型转换错误，返回当前时间");
			return (T) new Date();
		}
	}

	static <T extends Date> String toStringDate(T t, String type) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
		return simpleDateFormat.format(t);
	}
}

public class TestGenneric05 {
	public static void main(String[] args) {
//		List<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		CollectionUtil.print(list);

		Date time = DateUtils.toDate("2019-01-02", "yyyy-MM-dd");
		System.out.println(time);
		String data = DateUtils.toStringDate(new Date(),"yyyy-MM-dd");
		System.out.println(data);
	}
}
