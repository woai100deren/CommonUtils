package com.dj.library;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;


/**
 * 设备相关工具类
 */
public class DeviceUtils {
    /**
     * 其他设备
     */
    public static final String SYS_OTHER = "sys_other";
    /**
     * 华为
     */
    public static final String SYS_EMUI = "sys_emui";
    /**
     * 小米
     */
    public static final String SYS_MIUI = "sys_miui";
    /**
     * 魅族
     */
    public static final String SYS_FLYME = "sys_flyme";

    private static final String HUAWEI = "huawei";
    private static final String XIAOMI = "xiaomi";
    private static final String MEIZU = "meizu";

    /**
     * 返回当前程序版本名
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        try {
            // ---获得程序版本信息---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return "V" + versionName;
    }

    /**
     * 获取系统V
     * @return
     */
    public static String getSystem(){
        String SYS = SYS_OTHER;
        try {
            String vendor= android.os.Build.MANUFACTURER;
            if(vendor != null && vendor.toLowerCase().contains(HUAWEI)){
                //华为
                SYS = SYS_EMUI;
            }else if(vendor != null && vendor.toLowerCase().contains(XIAOMI)){
                //小米
                SYS = SYS_MIUI;
            }else if(vendor != null && vendor.toLowerCase().contains(MEIZU)){
                //魅族
                SYS = SYS_FLYME;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return SYS;
    }

    /**
     * 是否小米设备
     *
     * @return
     */
    public static boolean isMIUI() {

        return TextUtils.equals(getSystem(), SYS_MIUI);
    }

    /**
     * 是否华为设备
     */
    public static boolean isEMUI(){
        return TextUtils.equals(getSystem(), SYS_EMUI);
    }

    /**
     * 是否魅族设备
     *
     * @return
     */
    public static boolean isFlyme() {

        return TextUtils.equals(getSystem(), SYS_FLYME);
    }
}
