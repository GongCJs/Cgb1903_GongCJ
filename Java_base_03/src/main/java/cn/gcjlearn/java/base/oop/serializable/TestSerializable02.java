package cn.gcjlearn.java.base.oop.serializable;

import lombok.*;

import java.io.*;
import java.util.Base64;

/**
 * @author ：GongCJ
 * @date ：Created in 08-08-2019 10:40
 * @description：序列化加密输出与读取
 * @modified By：
 * @version: $
 */

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class TestSerializable0201 implements Serializable{

	private String name;
	private Integer age;
	private String sex;

	private void writeObject(ObjectOutputStream out) throws IOException {
		Base64.Encoder encoder = Base64.getEncoder();
		this.name = new String(encoder.encode(this.name.getBytes()));
		System.out.println("序列化开始了");
		out.defaultWriteObject();
	}
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		Base64.Decoder decoder = Base64.getDecoder();
		System.out.println("反序列化开始了");
		in.defaultReadObject();
		this.name = new String(decoder.decode(this.name));
	}
}

/**
 * @author Gongcj
 */
public class TestSerializable02 {
	public static void main(String[] args) throws IOException {
		String fileName = "D:"+ File.separator+"Serializable.txt";

//		TestSerializable0201 testSerializable0201
//				= new TestSerializable0201("GongCJ",22,"男");
//		SerializableUtils.serializable(testSerializable0201,fileName);


		TestSerializable0201 testSerializable0201
				=SerializableUtils.deSerializable(fileName);
		System.out.println(testSerializable0201.toString());
	}


}
