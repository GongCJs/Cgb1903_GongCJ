package cn.gcjlearn.sp09feign.service;

import com.tedu.sp01.pojo.Order;
import com.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

/**
 * @author ：GongCJ
 * @date ：Created in 08-21-2019 21:19
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class OrderFeignServiceFB implements OrderFeignService {

	@Override
	public JsonResult<Order> getOrder(String orderId) {
		return JsonResult.err("无法获取商品订单");
	}

	@Override
	public JsonResult addOrder() {
		return JsonResult.err("无法保存订单");
	}

}
