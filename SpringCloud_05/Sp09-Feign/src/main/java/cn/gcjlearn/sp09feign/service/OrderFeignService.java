package cn.gcjlearn.sp09feign.service;

import com.tedu.sp01.pojo.Order;
import com.tedu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：GongCJ
 * @date ：Created in 08-21-2019 20:54
 * @description：
 * @modified By：
 * @version: $
 */
@FeignClient(name="order-service",fallback = OrderFeignServiceFB.class)
public interface OrderFeignService {
	@GetMapping("/{orderId}")
	JsonResult<Order> getOrder(@PathVariable String orderId);

	@GetMapping("/")
	JsonResult addOrder();
}