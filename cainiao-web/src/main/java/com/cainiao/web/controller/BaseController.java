package com.cainiao.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : BaseController
 * @Description : 控制层基础类
 * @Author : Cai
 * @Date: 2020/12/8
 */
@Slf4j
@RestController
public class BaseController {

    /* *
     * @desc web层参数泄露问题
     * @return {@link }
     * @author Cai
     * @date 2020/12/8
     */
    @InitBinder()
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields();
    }
}
