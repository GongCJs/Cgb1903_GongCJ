package cn.gcjlearn.springcloud.service;


import cn.gcjlearn.springcloud.pojo.User;

public interface UserService {
	User getUser(Integer id);
	void addScore(Integer id, Integer score);
}
