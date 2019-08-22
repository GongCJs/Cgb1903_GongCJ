package cn.gcjlearn.sp04orderservice.service;

import cn.gcjlearn.sp01commons.pojo.Order;
import cn.gcjlearn.sp01commons.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ：GongCJ
 * @date ：Created in 08-21-2019 17:39
 * @description：
 * @modified By：
 * @version: $
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public Order getOrder(String orderId) {
		//TODO: 调用user-service获取用户信息
		//TODO: 调用item-service获取商品信息
		Order order = new Order();
		order.setId(orderId);
		return order;
	}

	@Override
	public void addOrder(Order order) {
		//TODO: 调用item-service减少商品库存
		//TODO: 调用user-service增加用户积分
		log.info("保存订单：" + order);
	}

}