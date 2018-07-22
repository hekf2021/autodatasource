package com.eck.auto.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * 统一处理错误异常消息格式
 */
public class MyException extends RuntimeException {
    private Log logger = LogFactory.getLog(getClass());
    private int httpCode;//http错误码
    private String code;//业务code：成都为success,失败为其它业务,如roleIdIsNull")
    private String message;//错误详情
    private Object data;//其它数据


    public MyException(int httpCode, String code, String message) {
        this.httpCode = httpCode;
        this.code = code;
        this.message = message;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String log=" httpCode:"+ httpCode +"\n code:"+code+"\n message:"+ message;
        logger.debug(log);
        return log;
    }
}
