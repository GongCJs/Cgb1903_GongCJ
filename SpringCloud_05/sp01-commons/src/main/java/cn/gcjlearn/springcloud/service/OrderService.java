package cn.gcjlearn.springcloud.service;

import cn.gcjlearn.springcloud.pojo.Order;

public interface OrderService {
	Order getOrder(String orderId);
	void addOrder(Order order);
}
