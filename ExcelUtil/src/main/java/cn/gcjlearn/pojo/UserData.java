package cn.gcjlearn.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ：GongCJ
 * @date ：Created in 08-09-2019 11:02
 * @description：创建要给测试数据
 * @modified By：
 * @version: $
 */

public class UserData {
	private UserData(){}
	public static List<User> getUserData() {
		List<User> users = new ArrayList<>(11);
		for (int i = 0; i < 10 ; i++) {
//			users.add(new User("用户名"+new Random().nextInt(100),new Random().nextInt(100)+"","男","测试"+new Random().nextInt(100),"测试"+new Random().nextInt(100),"测试"+new Random().nextInt(100)));
			users.add(new User("用户名"+new Random().nextInt(100),new Random().nextInt(100),"男","测试"+new Random().nextInt(100),"测试"+new Random().nextInt(100),"测试"+new Random().nextInt(100)));
		}
		return users;
	}
}
