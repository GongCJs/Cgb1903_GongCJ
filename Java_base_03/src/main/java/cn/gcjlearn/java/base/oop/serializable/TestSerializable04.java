package cn.gcjlearn.java.base.oop.serializable;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import java.io.*;

/**
 * @author ：GongCJ
 * @date ：Created in 08-08-2019 15:48
 * @description：使用hessian实现序列化
 * @modified By：
 * @version: $
 */
public class TestSerializable04 {
	public static void main(String[] args) throws IOException {
		String fileName = "D:" + File.separator + "Externaliazble.txt";
		SerializableData data
				= new SerializableData("GongCJ", 22, "男");

		OutputStream os = new FileOutputStream(fileName);
		Hessian2Output out = new Hessian2Output(os);
		out.writeObject(data);
		out.close();
		os.close();

		InputStream is = new FileInputStream(fileName);
		Hessian2Input in = new Hessian2Input(is);
		SerializableData data1 = (SerializableData) in.readObject();
		in.close();
		is.close();
		System.out.println(data1);

	}
}
