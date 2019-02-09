package com.jxiaqiudong.floatballtest;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;

/**
 * Created by wangxiandeng on 2016/11/25.
 */

public class AccessibilityUtil {
    /**
     * �������ع���
     * @param service
     */
    public static void doBack(AccessibilityService service) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            service.performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
        }
    }

    /**
     * ������֪ͨ��
     * @param service
     */
    public static void doPullDown(AccessibilityService service) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            service.performGlobalAction(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS);
        }
    }

    /**
     * ������������
     * @param service
     */
    public static void doPullUp(AccessibilityService service) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            service.performGlobalAction(AccessibilityService.GLOBAL_ACTION_HOME);
        }
    }

    /**
     * ���һ����򿪶�����
     * @param service
     */
    public static void doLeftOrRight(AccessibilityService service) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            service.performGlobalAction(AccessibilityService.GLOBAL_ACTION_RECENTS);
        }
    }

    public static boolean isAccessibilitySettingsOn(Context context) {
        int accessibilityEnabled = 0;
        try {
            accessibilityEnabled = Settings.Secure.getInt(context.getContentResolver(),
                    Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }

        if (accessibilityEnabled == 1) {
            String services = Settings.Secure.getString(context.getContentResolver(),
                    Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if (services != null) {
                return services.toLowerCase().contains(context.getPackageName().toLowerCase());
            }
        }

        return false;
    }



}
