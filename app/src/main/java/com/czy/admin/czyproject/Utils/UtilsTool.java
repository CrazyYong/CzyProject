package com.czy.admin.czyproject.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;

/**
 * Created by czy on 2017/6/8.
 */

public class UtilsTool {


    public static void goActivity(Context context, Class<? extends Activity> _class) {
        Intent intent = new Intent();
        intent.setClass(context, _class);
        context.startActivity(intent);
    }


    public static void sendError(String str, Handler handler){
        Message message = handler.obtainMessage();
        message.obj=str;
        message.what=1;
        handler.sendMessage(message);
    }



    public static String getVersion(Context context) {
             try {
                     PackageManager manager = context.getPackageManager();
                     PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
                       String version = info.versionName;
                     return  version;
                 } catch (Exception e) {
                     e.printStackTrace();
                     return "0";
                }
         }
}
