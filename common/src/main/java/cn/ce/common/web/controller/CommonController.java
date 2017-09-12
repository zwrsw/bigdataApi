package cn.ce.common.web.controller;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * 
 */

@Controller
public class CommonController {

	/** 日志  */
	private final Logger log = Logger.getLogger(CommonController.class);
	/**  
     * 用于处理异常的  
     * @return  
     */  
    @ExceptionHandler({Exception.class})   
    public String exception(Exception e) {
        log.error("共用异常："+ExceptionUtils.getStackTrace(e));
        e.printStackTrace();
        return "error";   
    }
	
}
