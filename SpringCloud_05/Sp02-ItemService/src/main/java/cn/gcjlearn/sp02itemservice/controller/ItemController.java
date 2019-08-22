package cn.gcjlearn.sp02itemservice.controller;

import cn.gcjlearn.sp01commons.pojo.Item;
import cn.gcjlearn.sp01commons.service.ItemService;
import cn.gcjlearn.sp01commons.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：GongCJ
 * @date ：Created in 08-21-2019 17:19
 * @description：
 * @modified By：
 * @version: $
 */
@Slf4j
@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;

	@Value("${server.port}")
	private int port;

	@GetMapping("/{orderId}")
	public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
		log.info("server.port="+port+", orderId="+orderId);

		List<Item> items = itemService.getItems(orderId);
		return JsonResult.ok(items).msg("port="+port);
	}

	@PostMapping("/decreaseNumber")
	public JsonResult decreaseNumber(@RequestBody List<Item> items) {
		itemService.decreaseNumbers(items);
		return JsonResult.ok();
	}
}