package cn.gcjlearn.pojo;

import cn.gcjlearn.common.Excel;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author ：GongCJ
 * @date ：Created in 08-09-2019 10:52
 * @description：User的pojo对象
 * @modified By：
 * @version: v1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Accessors(chain = true)
public class User {
	@Excel
	private String name;

	@Excel
	private Integer age;

	@Excel
	private String gender;

	@Excel
	private String test1;

	@Excel
	private String test2;

	@Excel
	private String test3;
}
