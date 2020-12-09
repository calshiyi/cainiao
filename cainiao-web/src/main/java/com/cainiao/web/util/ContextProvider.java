package com.cainiao.web.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * 类名： ContextProvider<br>
 * 描述： 获取上下文对象<br>
 * 创建日期： 2018/12/21 <br>
 *
 * @author Sun Tianchi
 * @version V1.0
 *
 */
public final class ContextProvider {
	
	private static ApplicationContext ctx = null;

	public static void setApplicationContext(ApplicationContext context) throws BeansException {

		if (ctx == null) {
			ctx = context;
		}
	}

	public static ApplicationContext getContext() {
		return ctx;
	}
	
	

	/**
	 * 作用： 根据 name 获取 <br>
	 * 作者：suntianchi<br>
	 * 创建日期： 2018/12/21<br>
	 * 版本： V1.0<br>
	 */
	public static Object getBean(String name) {
		return getContext().getBean(name);
	}

	/**
	 * 作用： 根据 class 获取 <br>
	 * 作者：suntianchi<br>
	 * 创建日期： 2018/12/21<br>
	 * 版本： V1.0<br>
	 */
	public static <T> T getBean(Class<T> clazz) {
		return getContext().getBean(clazz);
	}

	/**
	 * 作用： 根据 name + class 获取 <br>
	 * 作者：suntianchi<br>
	 * 创建日期： 2018/12/21<br>
	 * 版本： V1.0<br>
	 */
	public static <T> T getBean(String name, Class<T> clazz) {
		return getContext().getBean(name, clazz);
	}

}