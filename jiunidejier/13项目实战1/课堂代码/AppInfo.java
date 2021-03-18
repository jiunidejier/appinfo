package com.kgc.appmanager.entity;

import android.graphics.drawable.Drawable;

import com.kgc.appmanager.util.Utils;

/**
 * Created by uilubo on 2015/9/30.
 * 实体类: 应用的信息
 */
public class AppInfo {

    /** 包名 */
    public String packageName;
    /** 版本名 */
    public String versionName;
    /** 版本号 */
    public int versionCode;
    /** 第一次安装时间 */
    public long insTime;
    /** 更新时间 */
    public long updTime;
    /** 程序名 */
    public String appName;
    /** 图标 */
    public Drawable icon;
    /** 字节大小 */
    public long byteSize;
    /** 大小 */
    public String size;

    @Override
    public String toString() {
        return "\nAppInfo{" +
                "packageName='" + packageName + '\'' +
                ", versionName='" + versionName + '\'' +
                ", versionCode=" + versionCode +
                ", insTime=" + Utils.getTime(insTime) +
                ", updTime=" + Utils.getTime(updTime) +
                ", appName='" + appName + '\'' +
                ", icon=" + icon +
                ", byteSize=" + byteSize +
                ", size='" + size + '\'' +
                '}';
    }
}
