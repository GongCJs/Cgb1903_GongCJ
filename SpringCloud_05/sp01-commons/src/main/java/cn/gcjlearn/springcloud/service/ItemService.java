package cn.gcjlearn.springcloud.service;
import java.util.List;
import cn.gcjlearn.springcloud.pojo.Item;


/**
 * @author Gongcj
 */
public interface ItemService {
	List<Item> getItems(String orderId);
	void decreaseNumbers(List<Item> list);
}