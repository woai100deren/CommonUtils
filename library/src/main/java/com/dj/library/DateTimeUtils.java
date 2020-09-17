package com.dj.library;

import android.text.TextUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期时间工具类
 *
 * @author dongjifei
 * @date 2018/5/23
 */

public class DateTimeUtils {

    public final static String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public final static String DATE_FORMAT_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public final static String DATE_FORMAT_HH_MM = "HH:mm";
    public final static String DATE_FORMAT_YYYY_MM_DD_HH_MM_C = "yyyy年MM月dd日 HH:mm";


    /**
     * @param str 日期字符串
     * @return 日期转为格林威治时间
     */
    public static long getDaytime(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD_HH_MM_SS, Locale.CHINA);
        Date dt2 = null;
        try {
            dt2 = sdf.parse(str);
        } catch (ParseException e) {
            // ww_ Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {

        }
        if (null == dt2) {
            return 0;
        }
        return dt2.getTime();
    }


    /**
     * 获得字符串对应的date
     *
     * @param str
     * @param dateFormat
     * @return
     */
    public static Date convertToDate(String str, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.CHINA);
        Date dt2 = null;
        try {
            dt2 = sdf.parse(str);
        } catch (ParseException e) {
            // ww_ Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {

        }
        return dt2;
    }

    /**
     * 格式化时间
     *
     * @param datetimeStr 时间字符串
     * @param dateFormat  格式化字符串
     * @return 格式化后的时间
     */
    public static String datetime2String(String datetimeStr, String dateFormat) {
        return datetime2String(convertToDate(datetimeStr, dateFormat), dateFormat);
    }

    public static String datetime2String(Date datetime, String dateFormat) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.CHINA);
            return sdf.format(datetime);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return "";
    }


    /**
     * @param startTime
     * @param endTime
     * @return 毫秒
     */
    public static long difDatetime(Date startTime, Date endTime) {
        if (null == startTime || null == endTime) {
            return 0;
        }
        return Math.abs(endTime.getTime() - startTime.getTime());
    }


    public static int div(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, BigDecimal.ROUND_HALF_UP).intValue();
    }

    /**
     * <dt>功能：提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。</dt>
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * @param timeStr 时间字符串
     * @param dateFormat 格式
     * @return 时间的long值
     */
    public static long getDaytime(String timeStr, String dateFormat) {
        if (TextUtils.isEmpty(timeStr)){
            return 0;
        }

        return convertToDate(timeStr, dateFormat).getTime();
    }

    /**
     * String  转  date
     * @param sDate 格式：2008-08-08 12:10:12
     * @return
     */
    public static Date stringToDate(String sDate){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(sDate);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
