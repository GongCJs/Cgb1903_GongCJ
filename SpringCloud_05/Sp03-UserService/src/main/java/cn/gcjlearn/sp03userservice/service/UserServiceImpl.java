package cn.gcjlearn.sp03userservice.service;

import cn.gcjlearn.sp01commons.pojo.User;
import cn.gcjlearn.sp01commons.service.UserService;
import cn.gcjlearn.sp01commons.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：GongCJ
 * @date ：Created in 08-21-2019 17:29
 * @description：
 * @modified By：
 * @version: $
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
	@Value("${sp.user-service.users}")
	private String userJson;

	@Override
	public User getUser(Integer id) {
		log.info("users json string : " + userJson);
		List<User> list = JsonUtil.from(userJson, new TypeReference<List<User>>() {
		});
		for (User u : list) {
			if (u.getId().equals(id)) {
				return u;
			}
		}

		return new User(id, "name-" + id, "pwd-" + id);
	}

	@Override
	public void addScore(Integer id, Integer score) {
		//TODO 这里增加积分
		log.info("user " + id + " - 增加积分 " + score);
	}

}
