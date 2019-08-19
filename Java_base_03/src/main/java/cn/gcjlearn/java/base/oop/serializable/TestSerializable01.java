package cn.gcjlearn.java.base.oop.serializable;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.*;

/**
 * @author ：GongCJ
 * @date ：Created in 08-08-2019 9:54
 * @description：利用ObjectMappr将对象转换为JSON进行序列化输出序列化测试
 * @modified By：
 * @version: $
 */


@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class TestSerializable0101 implements Serializable{
	transient private String name;
	transient private Integer age;
}



/**
 * @author Gongcj
 */
public class TestSerializable01 {
	private static ObjectMapper objectMapper = null;
	static {
		objectMapper = new ObjectMapper();
	}
	public static void main(String[] args) throws IOException {
		String fileName = "D:"+File.separator+"Serializable.txt";

		TestSerializable0101 testSerializable0101
				= new TestSerializable0101("GongCJ",22);
		serializable(testSerializable0101,fileName);

//		TestSerializable0101 testSerializable0102
//				= deSerializable(TestSerializable0101.class,fileName);
//		System.out.println(testSerializable0102.toString());


	}
	private static boolean serializable(Object object,String fileName){
		Writer writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			objectMapper.writeValue(writer,object);
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	};

	private static <T>T deSerializable(Class<T> cla,String fileName){
		Reader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			T t =  objectMapper.readValue(reader,cla);
			return t;
		}catch (IOException e){
			return null;
		}
	};
}
