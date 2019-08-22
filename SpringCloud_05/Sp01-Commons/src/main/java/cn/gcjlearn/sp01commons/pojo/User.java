package cn.gcjlearn.sp01commons.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author ：GongCJ
 * @date ：Created in 08-21-2019 17:04
 * @description：
 * @modified By：
 * @version: $
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Integer id;
	private String username;
	private String password;
}
