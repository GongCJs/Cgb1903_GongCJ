package cn.gcjlearn.java.base.proxy.jdk.staticproxy;

/**
 * @author ：GongCJ
 * @date ：Created in 08-16-2019 17:09
 * @description：
 * @modified By：
 * @version: $
 */
public class DefaultExecutor implements Executor {
	@Override
	public void execute() {
		System.out.println("执行SQL语句");
	}
}
