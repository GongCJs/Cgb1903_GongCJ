package cn.gcjlearn.sp01commons.service;
import cn.gcjlearn.sp01commons.pojo.Item;

import java.util.List;
/**
 * @author ：GongCJ
 * @date ：Created in 08-21-2019 17:05
 * @description：
 * @modified By：
 * @version: $
 */
public interface ItemService {
	List<Item> getItems(String orderId);
	void decreaseNumbers(List<Item> list);
}
