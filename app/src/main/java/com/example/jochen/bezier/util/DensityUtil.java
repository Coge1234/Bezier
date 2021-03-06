package com.example.jochen.bezier.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewConfiguration;

import java.lang.reflect.Field;

/**
 * Created by JoChen on 2017/5/19.
 */

public class DensityUtil {
    public static float sDensity = 1.0f;
    public static int sDensityDpi;
    public static int sWidthPixels = 0;
    public static int sHeightPiels = 0;
    public static float sTouchSlop = 15f;
    public static float sFontDensity;
    public static int sTopStatusHeight;

    public static void resetDensity(Context context) {
        if (context != null && null != context.getResources()) {
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            //屏幕密度，density和dpi的关系为 density = dpi/160
            sDensity = metrics.density;
            //字体显示的缩放因子，跟上面的density是一样
            sFontDensity = metrics.scaledDensity;
            //设备的绝对宽度，单位是px
            sWidthPixels = metrics.widthPixels;
            //设备的绝对高度，单位是px
            sHeightPiels = metrics.heightPixels;
            //单位尺寸的像素点
            sDensityDpi = metrics.densityDpi;
            try {
                final ViewConfiguration configuration = ViewConfiguration.get(context);
                if (null != configuration) {
                    sTouchSlop = configuration.getScaledTouchSlop();
                }
            } catch (Error e) {
                Log.i("DensityUtils", "resetDensity has error" + e.getMessage());
            }
        }
    }

    public static int getStatusBarHeight(Context context) {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0;
        int top = 0;
        //从系统R文件中找到dimen这个内部类，
        // 然后通过反射拿到dimen中的status_bar_height的值，这个值其实就是资源id，
        // 然后再通过getResource方法拿到该id对应的值，
        try {
            c = Class.forName("com.android.internal.R$dimen");

            obj = c.newInstance();

            field = c.getField("status_bar_height");

            x = Integer.parseInt(field.get(obj).toString());

            top = context.getResources().getDimensionPixelSize(x);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return top;
    }

    /**
     * dip/dp转像素
     *
     * @param dipValue dip或 dp大小
     * @return 像素值
     */
    public static int dip2px(float dipValue) {
        return (int) (dipValue * sDensity + 0.5f);
    }

    /**
     * 像素转dip/dp
     *
     * @param pxValue 像素大小
     * @return dip值
     */
    public static int px2dip(float pxValue) {
        return (int) (pxValue / sDensity + 0.5f);
    }

    /**
     * sp 转 px
     *
     * @param spValue sp大小
     * @return 像素值
     */
    public static int sp2px(float spValue) {
        return (int) (sDensity * spValue);
    }

    /**
     * px转sp
     *
     * @param pxValue 像素大小
     * @return sp值
     */
    public static int px2sp(float pxValue) {
        return (int) (pxValue / sDensity);
    }
}
