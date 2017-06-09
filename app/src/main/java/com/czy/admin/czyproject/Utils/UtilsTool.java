package com.czy.admin.czyproject.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by czy on 2017/6/8.
 */

public class UtilsTool {


    public static void goActivity(Context context, Class<? extends Activity> _class) {
        Intent intent = new Intent();
        intent.setClass(context, _class);
        context.startActivity(intent);
    }
}
