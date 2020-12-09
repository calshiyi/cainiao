package com.cainiao.easyexcel;

import com.cainiao.easyexcel.bean.DemoTemplate;
import com.cainiao.easyexcel.util.DefaultExcelListener;
import com.cainiao.easyexcel.util.EasyExcelUtil;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName : EasyExcelDemo
 * @Description : 测试调用类
 * @Author : Cai
 * @Date: 2020/12/8
 */
public class EasyExcelDemo {

    @Test
    public void test() throws FileNotFoundException {
        DefaultExcelListener<DemoTemplate> listener = new DefaultExcelListener<>();
        File file = new File("G:\\project\\cainiao-main\\cainiao-easyexcel\\src\\test\\demo.xlsx");
        InputStream inputStream = new FileInputStream(file);
        EasyExcelUtil.asyncReadModel(inputStream,listener,DemoTemplate.class,0,1);
        List<DemoTemplate> rows = listener.getRows();
        System.out.println(rows);
    }
}
