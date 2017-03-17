package com.xlab.tools.common.io.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <p>
 * 日志处理的实用类
 * </p>
 * 
 */
public class LogUtil {
    
	/**
	 * <p>
	 * 常用的日志对象的获取
	 * </p>
	 * @return
	 */
	public static Logger getCommonLogger(){
		return LogManager.getLogger(LogUtil.class);
	}

	/** 
	 * <p>
	 * 获得某种类型的日志
	 * </p>
	 * @param str
	 * @return
	 */
	public static Logger getInputLogger(String str) {
		return LogManager.getLogger(str);
	}
}
