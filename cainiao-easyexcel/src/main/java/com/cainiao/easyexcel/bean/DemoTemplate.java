package com.cainiao.easyexcel.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName : PartakeActivityAgencyUploadRequest
 * @Description :
 * @Author : xuyufeng
 * @Date: 2019/12/26 下午6:02
 */

@Data
public class DemoTemplate{

    //经销商代码
    @ExcelProperty(value = "姓名")
    private String name;
    //经销商退出时间
    @ExcelProperty(value = "日期")
    private Date date;
}
