package cn.gcjlearn.sp01commons.service;

import cn.gcjlearn.sp01commons.pojo.User;

/**
 * @author ：GongCJ
 * @date ：Created in 08-21-2019 17:06
 * @description：
 * @modified By：
 * @version: $
 */
public interface UserService {
	User getUser(Integer id);
	void addScore(Integer id, Integer score);
}
