package cn.gcjlearn.springcloud.item.controller;

import cn.gcjlearn.springcloud.pojo.Item;
import cn.gcjlearn.springcloud.service.ItemService;
import cn.gcjlearn.springcloud.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gongcj
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