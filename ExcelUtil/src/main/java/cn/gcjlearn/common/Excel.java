package cn.gcjlearn.common;

import java.lang.annotation.*;

/**
 * @author ：GongCJ
 * @date ：Created in 08-09-2019 10:52
 * @description：添加excel字段名称字段
 * @modified By：
 * @version: v1.0
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Excel {
	/**
	 * 设置列名称
	 * @return
	 */
	String titleName() default "";
}
