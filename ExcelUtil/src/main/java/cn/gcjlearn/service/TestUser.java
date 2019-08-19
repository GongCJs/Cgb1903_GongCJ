package cn.gcjlearn.service;

import cn.gcjlearn.excel.ExcelUtils;
import cn.gcjlearn.pojo.User;
import cn.gcjlearn.pojo.UserData;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author ：GongCJ
 * @date ：Created in 08-09-2019 11:02
 * @description：
 * @modified By：
 * @version: $
 */
public class TestUser {
	public static void main(String[] args) throws InterruptedException {
//		List<User> users = UserData.getUserData();
//		String fileName = "D:"+System.currentTimeMillis();
//		ExcelUtils.toExcel(User.class,users).buildExcelFile(fileName);
//		System.out.println("生成成功");

		//自定义转换规则
		ExcelUtils.ConvertType convertType = new ExcelUtils.ConvertType() {
			@Override
			public void convertType(String typeName, String value) throws IllegalAccessException, InvocationTargetException {
				switch (typeName) {
					case "Integer":
						doConvertType(new Integer(value));
						break;
					case "String":
						doConvertType(value);
						break;
					default:

				}
			}
		};

		List<User> users1 = ExcelUtils.toEntry(User.class).parseExcel("D:" + File.separator + "1565613459248.xls", 0, convertType);
		users1.forEach(System.out::println);
		System.out.println("解析成功");
	}
}
