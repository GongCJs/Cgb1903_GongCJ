package cn.gcjlearn.sp09feign.service;

import com.tedu.sp01.pojo.User;
import com.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

/**
 * @author ：GongCJ
 * @date ：Created in 08-21-2019 21:18
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class UserFeignServiceFB implements UserFeignService {

	@Override
	public JsonResult<User> getUser(Integer userId) {
		return JsonResult.err("无法获取用户信息");
	}

	@Override
	public JsonResult addScore(Integer userId, Integer score) {
		return JsonResult.err("无法增加用户积分");
	}

}
