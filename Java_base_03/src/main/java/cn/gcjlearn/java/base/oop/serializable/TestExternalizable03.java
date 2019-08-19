package cn.gcjlearn.java.base.oop.serializable;

import lombok.*;

import java.io.*;

/**
 * @author ：GongCJ
 * @date ：Created in 08-08-2019 14:58
 * @description：利用Externalizable 实现序列化
 * @modified By：
 * @version: $
 */
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class TestExternalizable0301 implements Externalizable{
	private String name;
	private Integer age;
	private String sex;

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.name);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.name = (String) in.readObject();
	}
}

public class TestExternalizable03{
	public static void main(String[] args) {
		String fileName = "D:"+ File.separator+"Externaliazble.txt";
		TestExternalizable0301 testExternalizable0301 = null;

//		testExternalizable0301 = new TestExternalizable0301("GongCJ",20,"男");
//		SerializableUtils.serializable(testExternalizable0301,fileName);

		testExternalizable0301 = SerializableUtils.deSerializable(fileName);
		System.out.println(testExternalizable0301);
	}

}
