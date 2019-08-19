package cn.gcjlearn.jvm.gc;

public class TestGC01 {
	public static void main(String[] args) {
		byte[] b1 = new byte[1024 * 1024];// 分配 1MB 堆空间，考察堆空间的使用情况
		byte[] b2 = new byte[1024 * 1024];
		byte[] b3 = new byte[1024 * 1024];
		byte[] b4 = new byte[1024 * 1024];
	}

}
