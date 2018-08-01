package com.czy.admin.czyproject.Reflect;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by cmx on 2018/8/1.
 */

public class ReflectActivity extends Activity{
private TextView textView;
private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //获取布局文件ID
        int layoutID=ResourceUtils.getIdFromLayout(this,"activity_reflect");
        setContentView(layoutID);

        //获取TextView的id
        textView=(TextView)findViewById(ResourceUtils.getIdFromId(this,"tv"));

        //获取string.xml中的字符串
        textView.setText( ResourceUtils.getResString( this , "app_name"));

        //获取ImageView的id
        imageView = (ImageView) findViewById( ResourceUtils.getIdFromId( this , "image"));

        //获取 Mipmap 里面的 Drawable
        imageView.setImageDrawable( ResourceUtils.getMipmapFromString( this , "ic_launcher"));

        //获取 Drawable 里面的 Drawable
        imageView.setImageDrawable( ResourceUtils.getDrawableFromString( this , "ic_launcher"));


    }
}
