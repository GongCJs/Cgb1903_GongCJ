package cn.gcjlearn.sp01commons.service;

import cn.gcjlearn.sp01commons.pojo.Order;

/**
 * @author ：GongCJ
 * @date ：Created in 08-21-2019 17:06
 * @description：
 * @modified By：
 * @version: $
 */
public interface OrderService {
	Order getOrder(String orderId);
	void addOrder(Order order);
}