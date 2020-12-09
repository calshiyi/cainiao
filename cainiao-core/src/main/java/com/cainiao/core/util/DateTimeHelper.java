package com.cainiao.core.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* *
 * @desc 日期转换工具类
 * @author Cai
 * @date 2020/12/8
 */
public class DateTimeHelper {

    public final static String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_PATTERN1 = "yyyy/MM/dd HH:mm:ss";
    public final static String DATE_PATTERN2 = "yyyy/MM/dd HH:mm";
    public final static String DATE_PATTERN3 = "yyyy/MM/dd";
    public final static String DATE_MONTH_PATTERN = "yyyy-MM";
    public final static String DATE_DAY_PATTERN = "yyyy-MM-dd";

    //字符串转日期
    public static Date strFormatDate(String dateTime, String format) throws ParseException { return new SimpleDateFormat(format).parse(dateTime);}

    //字符串转日期时间戳
    public static long strFormatToInstantLong(String dateTime, String format) throws ParseException { return strFormatDate(dateTime, format).toInstant().toEpochMilli();}

    //日期转字符串
    public static String dateFormatStr(Date dateTime, String format){ return new SimpleDateFormat(format).format(dateTime);}

    //日期转字符串
    public static String convertDateToString(Date date) {
        return convertDateToString(date,DATE_PATTERN);
    }

    //日期转字符串
    public static String convertDateToString(Date date,String pattern) { return date!=null ? new SimpleDateFormat(pattern).format(date) : null;}

    //字符串类型转换日期
    public static Date convertStringToDate(String dateStr) throws ParseException { return convertStringToDate(dateStr,DATE_PATTERN); }

    //字符串类型转换日期
    public static Date convertStringToDate(String dateStr,String pattern) throws ParseException { return StringUtils.isEmpty(dateStr) ? new SimpleDateFormat(pattern).parse(dateStr) : null;}

    //时间戳转换日期格式
    public static String convertLongDateToString(long date, String pattern) { return convertDateToString(new Date(date),pattern);}

    //时间戳转换日期格式
    public static String convertLongDateToString(long date) { return convertLongDateToString(date,DATE_PATTERN);}




}
