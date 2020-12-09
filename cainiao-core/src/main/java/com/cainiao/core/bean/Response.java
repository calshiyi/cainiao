package com.cainiao.core.bean;


import java.io.Serializable;

/**
 * @ClassName : Response
 * @Description : 接口返回结果类
 * @Author : Cai
 * @Date: 2019-12-10 14:05
 */
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -8912267628340132131L;

    private int code = HttpBizCode.SUCCESS.getCode();
    private String message = "SUCCESS";
    private T data;
    public static <T> Response<T> newInstance() {
        return new Response<>();
    }

    /**
     * 成功调用
     * @param code
     * @param message
     * @param data
     * @return
     */
    public Response<T> fill(HttpBizCode code, String message, T data) {
        this.code = code == null ? HttpBizCode.SUCCESS.getCode() : code.getCode();
        this.message = message;
        this.data = data;
        return this;
    }
    /**
     * 成功调用
     * @param data
     * @return
     */
    public Response<T> fill(T data) {
        this.code = HttpBizCode.SUCCESS.getCode();
        this.data = data;
        return this;
    }
    public Response<T> fill(T data,String date) {
        this.code = HttpBizCode.SUCCESS.getCode();
        this.data = data;
        return this;
    }
    /**
     * 成功调用
     * @param data
     * @return
     */
    public Response<T> fill(String message,T data) {
        this.code = HttpBizCode.SUCCESS.getCode();
        this.message = message;
        this.data = data;
        return this;
    }
    
    /**
     * 成功调用
     * @param code
     * @param message
     * @return
     */
    public Response<T> fill(HttpBizCode code, String message) {
        this.code = code == null ? HttpBizCode.SUCCESS.getCode() : code.getCode();
        this.message = message;
        return this;
    }

    /**
     * 失败调用  code必须不等于200
     * @param code
     * @param message
     * @return
     */
    public Response<T> fail(HttpBizCode code, String message) {
        this.code = code == null ? HttpBizCode.SUCCESS.getCode() : code.getCode();
        this.message = message;
        return this;
    }

    public Boolean isSuccess() {
        return HttpBizCode.SUCCESS.getCode() == code;
    }

    public Response() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public  T getData() {
        return data;
    }

    @SuppressWarnings("rawtypes")
	public Response setData(T data) {
        this.data = data;
        return this;
    }

}