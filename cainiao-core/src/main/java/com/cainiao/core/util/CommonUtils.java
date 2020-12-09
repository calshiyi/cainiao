package com.cainiao.core.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @ClassName : CommentUtils
 * @Description : 通用工具类
 * @Author : Cai
 * @Date: 2020-01-02 14:07
 */
public class CommonUtils {


    public static void copyProperties(Object from,Object to) throws IllegalAccessException, ParseException {
        copyProperties(from, to,DateTimeHelper.DATE_PATTERN);
    }

    //datePattern date字段转换类型
    public static void copyProperties(Object from,Object to,String datePattern) throws IllegalAccessException, ParseException {
            Class<?> fromClass = from.getClass();
            Class<?> toClass = to.getClass();
            Field[] fromFields = fromClass.getDeclaredFields();
            Field[] toFields = toClass.getDeclaredFields();
            for (Field field : fromFields) {
                //设置是否允许访问，不是修改原来的访问权限修饰词。
                field.setAccessible(true);
                Object value = field.get(from);
                if (value != null) {
                    for (Field tofield : toFields) {
                        tofield.setAccessible(true);
                        if (tofield.getName().equals(field.getName())) {
                            //如果存在属性
                            // 得到此属性的类型
                            String type = field.getType().toString();
                            String toType = tofield.getType().toString();
                            if (type.endsWith("Date")) {
                                if (toType.endsWith("String")) {
                                    tofield.set(to, DateTimeHelper.convertDateToString(((Date) value), datePattern));
                                } else if (toType.endsWith("Long")) {
                                    tofield.set(to, ((Date) value).getTime());
                                } else if (toType.endsWith("Date")) {
                                    tofield.set(to, value);
                                }
                            } else if (type.endsWith("Long")) {
                                if (toType.endsWith("String")) {
                                    tofield.set(to, DateTimeHelper.convertLongDateToString(((Long) value), datePattern));
                                } else if (toType.endsWith("Date")) {
                                    tofield.set(to, new Date((Long) value));
                                } else if (toType.endsWith("Long")) {
                                    tofield.set(to, value);
                                }
                            } else if (type.endsWith("String")) {
                                if (toType.endsWith("Date")) {
                                    tofield.set(to, DateTimeHelper.convertStringToDate((value.toString()), datePattern));
                                } else if (toType.endsWith("Long")) {
                                    tofield.set(to, DateTimeHelper.convertStringToDate(value.toString()).getTime());
                                } else if (toType.endsWith("String")) {
                                    tofield.set(to, value);
                                }
                            } else if (type.endsWith("Integer")) {
                                if (toType.endsWith("String")) {
                                    tofield.set(to, String.valueOf(value));
                                } else if (toType.endsWith("Integer")) {
                                    tofield.set(to, value);
                                }
                            } else {
                                tofield.set(to, value);
                            }
                            break;
                        }
                    }
                }
            }
    }

    public static boolean hasEmptyInAllStr(String... str){
        if(str==null) return false;
        for (String temp : str) {
            if (StringUtils.isEmpty(temp)){
                return true;
            }
        }
        return false;
    }

    //获取字符串的长度，如果有中文，则每个中文字符计为2位
    public static int length(String value) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < value.length(); i++) {
            /* 获取一个字符 */
            String temp = value.substring(i, i + 1);
            /* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
                /* 中文字符长度为2 */
                valueLength += 2;
            } else {
                /* 其他字符长度为1 */
                valueLength += 1;
            }
        }
        return valueLength;
    }
    //判断对象属性是否为空
    public static boolean objCheckIsNull(Object object) {
        if(object==null) return true;
        Class clazz = object.getClass(); // 得到类对象
        Field fields[] = clazz.getDeclaredFields(); // 得到所有属性
        boolean flag = true; // 定义返回结果，默认为true
        for (Field field : fields) {
            field.setAccessible(true);
            Object fieldValue = null;
            try {
                fieldValue = field.get(object); // 得到属性值
                // Type fieldType = field.getGenericType();// 得到属性类型
                //String fieldName = field.getName(); // 得到属性名
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
            if (fieldValue != null) { // 只要有一个属性值不为null 就返回false 表示对象不为null
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public static <T> T readJsonFile(String fileName, Class<T> clazz) throws IOException {
        String jsonStr = "";
        File jsonFile = new File(fileName);
        FileReader fileReader = new FileReader(jsonFile);
        Reader reader = new InputStreamReader(new FileInputStream(jsonFile), StandardCharsets.UTF_8);
        int ch = 0;
        StringBuilder sb = new StringBuilder();
        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        fileReader.close();
        reader.close();
        return JSONObject.toJavaObject(JSONObject.parseObject(sb.toString()), clazz);
    }


    public static String getErrorMessage(Exception e){
        if(null == e) return "";
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}
