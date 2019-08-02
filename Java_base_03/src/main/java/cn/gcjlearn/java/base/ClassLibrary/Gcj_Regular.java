package cn.gcjlearn.java.base.ClassLibrary;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gcj_Regular {
	public static void main(String[] args) {
		//去除程序中的除了 数字、字母以外的字符
//		String src = "165sd1f5153sdf%^&*_dsfsd___dafds-fdsf-sdf_($%^&^T*&(*&*&(*dsfsdfsd*(*(";
//		String regex = "[^a-zA-Z0-9]+";
//		String s = src.replaceAll(regex, "");
//		System.out.println(s);

		//根据字符进行拆分
//		String src = "123d152135d13515wsdfa132153g2135e1321y132313z3";
//		String regex = "[a-zA-Z]+";
//		String[] split = src.split(regex);
//		System.out.println(Arrays.toString(split));

		//判断一个数据是否为小数，如果是则将其变为double
//		String src = "123135.100";
//		String regex = "\\d+(\\.?\\d+)";
//		System.out.println(src.matches(regex));

		//判断一个字符串是否由日期所组成，如果是由日期所组成则将其转换为Date类型
//		String src ="2019-11-11";
//		String regex ="\\d{4}-\\d{1,2}-\\d{1,2}+( +\\d{1,2}:\\d{1,2}:\\d{1,2}.\\d{3})";
//		String regex ="\\d{4}-\\d{1,2}-\\d{1,2}";
//		System.out.println(src.matches(regex));

		//匹配电话号码
		//	1)	55759123		\d{7,8}
		//	2)	02355759123		(\d{3,4})?\d{7,8}
		//	3)	(023)-55759123
//		String src = "(010)-55759123";
//		String regex ="(\\d{3,4}?|(\\(\\d{3,4}\\)-)?)?\\d{7,8}?";
//		System.out.println(src.matches(regex));
		
		//Email 邮箱验证
//		String src = "gongcj_023@-163.cn";
//		String regex = "[a-zA-Z0-9]{1}\\w+@\\w*(\\-)*\\w*\\.(com|cn|org)+";
//		System.out.println(src.matches(regex));

		//取出#{}中的数据
//		String src = "insert into dept(deptno,dname,loc) values(#{deptno},#{dname},#{loc})";
//		//编译一个正则表达式
//		Pattern pattern = Pattern.compile("#\\{\\w+\\}");
//		Matcher matcher = pattern.matcher(src);
//		while (matcher.find()) {
////			System.out.println(matcher.group(0).replaceAll("[^a-zA-Z]",""));
//			System.out.println(matcher.group(0).replaceAll("\\#\\{|\\}",""));
//		}
		Locale loc = Locale.getDefault();
		System.out.println(loc);

	}
}
