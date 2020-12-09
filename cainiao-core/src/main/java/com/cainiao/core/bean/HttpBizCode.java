package com.cainiao.core.bean;

import lombok.Getter;

/**
 * Project:sioo-common File: com.sioo.cloud.common.core.model
 *
 * @author : xywei
 * @date : 2018-12-21 Copyright 2006-2018 Sioo Co., Ltd. All rights reserved.
 */
@Getter
public enum HttpBizCode {

	SUCCESS(200, "成功"), NOTLOGIN(201, "未登录"), ILLEGAL(202, "参数不合法"), NOTICE(203, "用户提示"), SYSERROR(204, "系统异常"),
	FORBIDDEN(205, "无操作权限"), OCCUPIED(206, "被占用"), BIZERROR(210, "业务异常"), NOT_EXISTS(211, "数据不存在"), EXPIRED(212, "已过期");

	private int code;
	private String text;

	HttpBizCode(int code, String text) {
		this.code = code;
		this.text = text;
	}
}
