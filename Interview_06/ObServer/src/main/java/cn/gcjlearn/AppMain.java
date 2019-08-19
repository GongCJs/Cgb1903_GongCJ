package cn.gcjlearn;

import java.util.ArrayList;



public class AppMain  {
	
	static WuKong wuKong;
	static BaJie baJie;
	static ShaSeng shaSeng;
	
	//Ŀ��
	static TangSeng tangSeng;
	public static void main(String[] args) {
		tangSeng = new TangSeng();

		wuKong = new WuKong();
		tangSeng.register(wuKong);

		baJie = new BaJie();
		tangSeng.register(baJie);

		shaSeng = new ShaSeng();
		tangSeng.register(shaSeng);
		
		ArrayList<String> list = tangSeng.help();
		System.out.println(list.toString());
	}

}
