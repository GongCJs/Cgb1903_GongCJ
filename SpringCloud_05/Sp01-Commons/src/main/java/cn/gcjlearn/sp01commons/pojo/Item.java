package cn.gcjlearn.sp01commons.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：GongCJ
 * @date ：Created in 08-21-2019 17:03
 * @description：
 * @modified By：
 * @version: $
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	private Integer id;
	private String name;
	private Integer number;
}
