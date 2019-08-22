package cn.gcjlearn.sp03userservice.controller;

import cn.gcjlearn.sp01commons.pojo.User;
import cn.gcjlearn.sp01commons.service.UserService;
import cn.gcjlearn.sp01commons.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：GongCJ
 * @date ：Created in 08-21-2019 17:29
 * @description：
 * @modified By：
 * @version: $
 */
@Slf4j
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{userId}")
	public JsonResult<User> getUser(@PathVariable Integer userId) {
		log.info("get user, userId=" + userId);
		User u = userService.getUser(userId);
		return JsonResult.ok(u);
	}

	@GetMapping("/{userId}/score")
	public JsonResult addScore(
			@PathVariable Integer userId, Integer score) {
		userService.addScore(userId, score);
		return JsonResult.ok();
	}
}
