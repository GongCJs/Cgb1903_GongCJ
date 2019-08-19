package cn.gcjlearn;

import java.util.ArrayList;

/**
 * Ŀ��
 * 
 */
public class TangSeng {
	ArrayList<Observer> list = new ArrayList<Observer>();

	public void register(Observer observer) {
		list.add(observer);
	}

	public ArrayList<String> help() {
		ArrayList<String> listString = new ArrayList<String>();
		//通知所有观察者
		for (Observer observer : list) {
			String str = observer.save();
			listString.add(str);
		}
		return listString;
	}
}
