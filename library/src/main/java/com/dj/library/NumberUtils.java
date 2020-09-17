package com.dj.library;

import android.text.TextUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数字相关工具类
 */
public class NumberUtils {
    /**
     * 字符转int
     *
     * @param str 字符
     * @return int
     */
    public static int parseInt(String str) {
        return parseInt(str, 0);
    }

    /**
     * 支持小数点，向上取整
     *
     * @param str          字符
     * @param defaultValue 默认值
     * @return int
     */
    public static int parseInt(String str, int defaultValue) {
        int number = defaultValue;
        if (!TextUtils.isEmpty(str)) {
            try {
                Double d = Double.parseDouble(str);
                d = Math.ceil(d);
                number = d.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return number;
    }


    /**
     * @param psd 密码
     * @return 密码强度是否合法（6-18位，数字和字母）
     */
    public static boolean isStrongPwd(String psd) {
        if (TextUtils.isEmpty(psd)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{6,18}$");
        return pattern.matcher(psd).matches();
    }

    /**
     * @param phone 文本
     * @return 是否是手机号
     */
    public static boolean isPhone(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$");
        return pattern.matcher(phone).matches();
    }


    /**
     * 简单的11位验证
     * @param phone
     * @return
     */
    public static boolean isSimplePhone(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^1(\\d{10})$");
        return pattern.matcher(phone).matches();
    }

    /**
     * 中文名字校验
     *
     * @param chineseText 中文名称
     * @return 是否合法
     */
    public static boolean isChineseName(String chineseText) {
        if (TextUtils.isEmpty(chineseText)) {
            return false;
        }
        Pattern p = Pattern.compile("^[*\\u4E00-\\u9FA5]{2,10}");
        Matcher m = p.matcher(chineseText);
        return m.matches();
    }

    /**
     * @param bankCardCheck 银行卡号
     * @return 银行卡号是否合法
     */
    public static boolean isBankcardNum(String bankCardCheck) {
        if (TextUtils.isEmpty(bankCardCheck)) {
            return false;
        }
        Pattern p = Pattern.compile("^(\\d{16,19})$");
        Matcher m = p.matcher(bankCardCheck);
        return m.matches();
    }

    /**
     * @param idCardNum 身份证号
     * @return 身份证号是否合法
     */
    public static boolean isIDCard(String idCardNum) {
        if (TextUtils.isEmpty(idCardNum)) {
            return false;
        }
        Pattern p = Pattern.compile("^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$");
        Matcher m = p.matcher(idCardNum);
        return m.matches();
    }

    /**
     * 精确的 减法运算
     *
     * @param var1 参数1
     * @param var2 参数2
     * @return
     */
    public static String sub(String var1, String var2) {
        if (TextUtils.isEmpty(var1) || TextUtils.isEmpty(var2)) {
            return "";
        }
        BigDecimal bigDecimal1 = new BigDecimal(var1);
        BigDecimal bigDecimal2 = new BigDecimal(var2);
        return bigDecimal1.subtract(bigDecimal2).toString();
    }

    /**
     * 精确的 加法运算
     *
     * @param var1 参数1
     * @param var2 参数2
     * @return
     */
    public static String add(String var1, String var2) {
        if (TextUtils.isEmpty(var1) || TextUtils.isEmpty(var2)) {
            return "";
        }
        BigDecimal bigDecimal1 = new BigDecimal(var1);
        BigDecimal bigDecimal2 = new BigDecimal(var2);
        return bigDecimal1.add(bigDecimal2).toString();
    }

    /**
     * 精确的 除法运算
     *
     * @param var1 参数1
     * @param var2 参数2
     * @return
     */
    public static String div(String var1, String var2) {
        if (TextUtils.isEmpty(var1) || TextUtils.isEmpty(var2)) {
            return "";
        }
        BigDecimal bigDecimal1 = new BigDecimal(var1);
        BigDecimal bigDecimal2 = new BigDecimal(var2);
        return bigDecimal1.divideToIntegralValue(bigDecimal2).toString();
    }

    /**
     * @param num 金额
     * @return 格式化输出本地货币字符,形如1,000.00
     */
    public static String formatLocalCurrency(String num) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String result = currencyFormat.format(parseDouble(num));
        return result.substring(1);
    }

    /**
     * @param str 源字符串
     * @return 字符串转double
     */
    public static double parseDouble(String str) {
        double number = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                number = Double.parseDouble(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return number;
    }

    /**
     * @param str 源字符串
     * @return 字符串转long
     */
    public static long parseLong(String str) {
        long number = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                number = Long.parseLong(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return number;
    }

    /**
     * @param d 数字
     * @return 格式化两位整数，首位自动补0
     */
    public static String format2Integer(int d) {
        DecimalFormat df = new DecimalFormat("00");
        return df.format(d);
    }

    /**
     * 预期收益 = 投资本金*预期年化收益率*产品实际存续天数/360
     * @param amount 投资本金
     * @param yearRate 预期年化收益率
     * @param days 产品实际存续天数
     * @return 预期收益
     */
    public static String calculateExpectedIncome(String amount, String yearRate, String days){
        if (TextUtils.isEmpty(amount) || TextUtils.isEmpty(yearRate) || TextUtils.isEmpty(days)){
            return "";
        }
        return calculateExpectedIncome(
                new BigDecimal(amount),
                new BigDecimal(yearRate).divide(new BigDecimal(100), 20, BigDecimal.ROUND_DOWN),
                new BigDecimal(days));
    }

    /**
     * 预期收益 = 投资本金*预期年化收益率*产品实际存续天数/360
     * @param amount 投资本金
     * @param yearRate 预期年化收益率
     * @param days 产品实际存续天数
     * @return 预期收益
     */
    public static String calculateExpectedIncome(BigDecimal amount, BigDecimal yearRate, BigDecimal days){
        return amount.multiply(yearRate)
                .multiply(days)
                .divide(new BigDecimal(360), 20, BigDecimal.ROUND_DOWN)
                .setScale(2, BigDecimal.ROUND_DOWN).toString();
    }

    /**
     * 精确的 乘法运算
     * @param var1 String 乘数1
     * @param var2 String 乘数2
     * @return
     */
    public static String mul(String var1, String var2) {
        if (TextUtils.isEmpty(var1) || TextUtils.isEmpty(var2)){
            return "";
        }
        BigDecimal bigDecimal1 = new BigDecimal(var1);
        BigDecimal bigDecimal2 = new BigDecimal(var2);
        return bigDecimal1.multiply(bigDecimal2).toString();
    }
}
