package cn.gcjlearn.sp09feign.controller;

import cn.gcjlearn.sp09feign.service.ItemFeignService;
import cn.gcjlearn.sp09feign.service.OrderFeignService;
import cn.gcjlearn.sp09feign.service.UserFeignService;
import com.tedu.sp01.pojo.Item;
import com.tedu.sp01.pojo.Order;
import com.tedu.sp01.pojo.User;
import com.tedu.web.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：GongCJ
 * @date ：Created in 08-21-2019 20:55
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class FeignController {
	@Autowired
	private ItemFeignService itemServcie;
	@Autowired
	private UserFeignService userServcie;
	@Autowired
	private OrderFeignService orderServcie;

	@GetMapping("/item-service/{orderId}")
	public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
		return itemServcie.getItems(orderId);
	}

	@PostMapping("/item-service/decreaseNumber")
	public JsonResult decreaseNumber(@RequestBody List<Item> items) {
		return itemServcie.decreaseNumber(items);
	}

	/////////////////////////////////////////

	@GetMapping("/user-service/{userId}")
	public JsonResult<User> getUser(@PathVariable Integer userId) {
		return userServcie.getUser(userId);
	}

	@GetMapping("/user-service/{userId}/score")
	public JsonResult addScore(@PathVariable Integer userId, Integer score) {
		return userServcie.addScore(userId, score);
	}

	/////////////////////////////////////////

	@GetMapping("/order-service/{orderId}")
	public JsonResult<Order> getOrder(@PathVariable String orderId) {
		return orderServcie.getOrder(orderId);
	}

	@GetMapping("/order-service")
	public JsonResult addOrder() {
		return orderServcie.addOrder();
	}
}