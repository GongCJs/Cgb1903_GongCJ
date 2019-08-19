package cn.gcjlearn.java.base.oop.serializable;

import lombok.*;

import java.io.Serializable;

/**
 * @author ：GongCJ
 * @date ：Created in 08-08-2019 16:07
 * @description：序列化类
 * @modified By：
 * @version: $
 */
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SerializableData implements Serializable {
	private String name;
	private Integer age;
	private String sex;
}
