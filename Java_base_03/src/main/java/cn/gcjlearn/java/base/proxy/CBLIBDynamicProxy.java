package cn.gcjlearn.java.base.proxy;

import java.sql.Driver;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：GongCJ
 * @date ：Created in 08-05-2019 10:14
 * @description：CGLIB动态代理
 * @modified By：
 * @version: $
 */
public class CBLIBDynamicProxy {
	public static void main(String[] args) {
		ServiceLoader.load(Driver.class);
	}
}
