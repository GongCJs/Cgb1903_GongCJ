package cn.gcjlearn.java.base.oop.serializable;

import java.io.*;

/**
 * @author ：GongCJ
 * @date ：Created in 08-08-2019 15:09
 * @description：序列化工具
 * @modified By：
 * @version: $
 */
public class SerializableUtils {
	private SerializableUtils(){};
	public static boolean serializable(Object object , String fileName){
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream =
					new ObjectOutputStream(
					new FileOutputStream(fileName));
			objectOutputStream.writeObject(object);
			objectOutputStream.close();
			System.out.println("序列化成功");
			return true;
		} catch (IOException e) {
			System.out.println("序列化失败");
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static <T>T deSerializable(String fileName){
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream =
					new ObjectInputStream(
					new FileInputStream(fileName));
			T t = (T) objectInputStream.readObject();
			objectInputStream.close();
			System.out.println("反序列化成功");
			return t;
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("反序列化失败");
			System.out.println(e.getMessage());
			return null;
		}
	}
}
