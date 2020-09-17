package com.dj.library;

import android.text.TextUtils;
import android.util.Log;

import com.orhanobut.logger.BuildConfig;
import com.orhanobut.logger.Logger;

/**
 * 日志打印工具类
 * @author apple
 */

public class LogUtils {
    public static final String LOG_TAG = LogUtils.class.getName();
    private static final boolean NATIVE_LOG = true;

    /**
     * 格式化打印json数据
     *
     * @param tag
     * @param jsonStr
     */
    public static void json(String tag, String jsonStr) {
        if (BuildConfig.DEBUG) {
            Logger.t(tag).json(jsonStr);
        }
    }

    /**
     * 格式化打印json数据
     *
     * @param jsonStr
     */
    public static void json(String jsonStr) {
        if (BuildConfig.DEBUG) {
            Logger.json(jsonStr);
        }
    }

    /**
     * 格式化打印xml数据
     *
     * @param tag
     * @param xmlStr
     */
    public static void xml(String tag, String xmlStr) {
        if (BuildConfig.DEBUG) {
            Logger.t(tag).xml(xmlStr);
        }
    }

    /**
     * 格式化打印xml数据
     *
     * @param xmlStr
     */
    public static void xml(String xmlStr) {
        if (BuildConfig.DEBUG) {
            Logger.xml(xmlStr);
        }
    }


    public static void i(String msg) {
        if (BuildConfig.DEBUG) {
            if (NATIVE_LOG) {
                Log.i(getTag(null), buildMessage(msg));
            } else {
                Logger.i(msg);
            }
        }
    }

    public static void i(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            if (NATIVE_LOG) {
                Log.i(getTag(tag), buildMessage(msg));
            } else {
                Logger.t(tag).i(msg);
            }
        }
    }

    public static void i(Object...msg){
        if (BuildConfig.DEBUG){
            Logger.i(buildMessage(msg));
        }
    }

    public static void v(String msg) {
        if (BuildConfig.DEBUG) {
            if (NATIVE_LOG) {
                Log.i(getTag(null), buildMessage(msg));
            } else {
                Logger.i(msg);
            }
        }
    }

    public static void v(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            if (NATIVE_LOG) {
                Log.i(getTag(tag), buildMessage(msg));
            } else {
                Logger.t(tag).i(msg);
            }
        }
    }

    public static void v(Object...msg){
        if (BuildConfig.DEBUG){
            Logger.v(buildMessage(msg));
        }
    }

    public static void w(String msg) {
        if (BuildConfig.DEBUG) {
            if (NATIVE_LOG) {
                Log.i(getTag(null), buildMessage(msg));
            } else {
                Logger.i(msg);
            }
        }
    }

    public static void w(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            if (NATIVE_LOG) {
                Log.i(getTag(tag), buildMessage(msg));
            } else {
                Logger.t(tag).i(msg);
            }
        }
    }

    public static void w(Object...msg){
        if (BuildConfig.DEBUG){
            Logger.w(buildMessage(msg));
        }
    }

    public static void e(String msg) {
        if (BuildConfig.DEBUG) {
            if (NATIVE_LOG) {
                Log.e(getTag(null), buildMessage(msg));
            } else {
                Logger.e(msg);
            }
        }
    }

    public static void e(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            if (NATIVE_LOG) {
                Log.e(getTag(tag), buildMessage(msg));
            } else {
                Logger.t(tag).e(msg);
            }
        }
    }

    public static void e(Object...msg){
        if (BuildConfig.DEBUG){
            Logger.e(buildMessage(msg));
        }
    }

    public static void d(String msg) {
        if (BuildConfig.DEBUG) {
            if (NATIVE_LOG) {
                Log.i(getTag(null), buildMessage(msg));
            } else {
                Logger.i(msg);
            }
        }
    }

    public static void d(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            if (NATIVE_LOG) {
                Log.i(getTag(tag), buildMessage(msg));
            } else {
                Logger.t(tag).i(msg);
            }
        }
//        saveLog2File(tag, msg);
    }

    public static void d(Object...msg){
        if (BuildConfig.DEBUG){
            Logger.d(buildMessage(msg));
        }
    }

    public static void e(Throwable thr) {
        e(null, thr);
    }

    public static void e(String tag, Throwable thr) {
        if (BuildConfig.DEBUG) {
            Log.e(getTag(tag), Log.getStackTraceString(thr));
        }
    }

    /**
     * 拼接tag
     *
     * @param tag 后缀
     * @return 完整tag
     */
    private static String getTag(String tag) {
        if (TextUtils.isEmpty(tag) || LOG_TAG.equals(tag)) {
            return LOG_TAG;
        }
        return LOG_TAG + "-" + tag;
    }

    /**
     * Building Message
     *
     * @param msg The message you would like logged.
     * @return Message String
     */
    protected static String buildMessage(String msg) {
        StackTraceElement caller = new Throwable().fillInStackTrace().getStackTrace()[2];

        String name = caller.getClassName();
        name = name.substring(name.lastIndexOf(".") + 1, name.length());

        return new StringBuilder()
                .append("『" + name)
                .append(".")
                .append(caller.getMethodName())
                .append("()』")
                .append(TextUtils.isEmpty(msg) ? "" : msg).toString();
    }

    private static String buildMessage(Object...msg){
        StringBuilder str = new StringBuilder();
        if (msg != null) {
            for (Object obj : msg) {
                if (obj == null) {
                    str.append("null").append(" ");
                    continue;
                }
                str.append(obj).append(" ");
            }
        } else {
            str.append("null");
        }
        return str.toString();
    }
}
