package com.czy.admin.czyproject.Reflect;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by cmx on 2018/8/1.
 */

public class ResourceUtils {

    public static int getIdByName(Context context, String className, String name) {
        return context.getResources().getIdentifier(name, className, context.getPackageName());
    }

    /**
     * 获取布局文件的资源ID
     * @param context
     * @param name
     * @return
     */
    public static int getIdFromLayout(Context context, String name) {
        return getIdByName(context, "layout", name);
    }

    /**
     * 从控件中获取资源的ID
     * @param context
     * @param name
     * @return
     */
    public static int getIdFromId(Context context, String name) {
        return getIdByName(context, "id", name);
    }

    /**
     * 从 strings.xml 里面获取资源的ID
     * @param context
     * @param name
     * @return
     */
    public static int getIdFromString(Context context, String name) {
        return getIdByName(context, "string", name);
    }

    /**
     * 从 Drawable 里面获取资源的ID
     * @param context
     * @param name
     * @return
     */
    public static int getIdFromDrawable(Context context, String name) {
        return getIdByName(context, "drawable", name);
    }

    /**
     * 从 Mipmap 里面获取资源的ID
     * @param context
     * @param name
     * @return
     */
    public static int getIdFromMipmap(Context context, String name) {
        return getIdByName(context, "mipmap", name);
    }

    /**
     * 从 strings.xml 里面获取字符串
     * @param context
     * @param name
     * @return
     */
    public static String getResString(Context context, String name) {
        return context.getString(getIdFromString(context, name));
    }

    /**
     * 从Drawable目录获取 Drawable 对象
     * @param context
     * @param name
     * @return
     */
    public static Drawable getDrawableFromString(Context context, String name ){
        return context.getResources().getDrawable( getIdFromDrawable( context , name ) ) ;
    }

    /**
     * 从Mipmap目录获取 Drawable 对象
     * @param context
     * @param name
     * @return
     */
    public static Drawable getMipmapFromString(Context context, String name ){
        return context.getResources().getDrawable( getIdFromMipmap( context , name ) ) ;
    }


}
