package com.czy.admin.czyproject.Gson;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.czy.admin.czyproject.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by czy on 2017/3/13.
 */

public class GsonActivity extends Activity{
private Button btn_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        btn_test=(Button)findViewById(R.id.btn_test);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gsonToGson();
            }
        });
    }


    /**
     * 基本数据类型解析
     */
    private void gsonData(){
        Gson gson = new Gson();
        int i = gson.fromJson("100", int.class);              //100
        double d = gson.fromJson("\"99.99\"", double.class);  //99.99
        boolean b = gson.fromJson("true", boolean.class);     // true
        String str = gson.fromJson("String", String.class);   // String
        Toast.makeText(GsonActivity.this,i+"--"+d+"---"+b+"---"+str,Toast.LENGTH_SHORT).show();
    }


    /**
     * 生成JSON
     */
    private void gsonToGson(){
        Gson gson = new Gson();
        User user = new User("路飞","25","523");
        String jsonObject = gson.toJson(user);
        Toast.makeText(GsonActivity.this,jsonObject,Toast.LENGTH_SHORT).show();
    }

    /**
     * 解析JSON
     */
    private void gsonToObj(){
        Gson gson = new Gson();
        String jsonString = "{\"name\":\"怪盗kidou\",\"age\":24}";
        User user = gson.fromJson(jsonString,User.class);
        Toast.makeText(GsonActivity.this,user.getName(),Toast.LENGTH_SHORT).show();
    }


    /**
     *
     *Gson中使用泛型
     */
    private void gsonToObj(int i){
        Gson gson = new Gson();
        String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
        String[] strings = gson.fromJson(jsonArray, String[].class);
        List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>() {}.getType());
        Toast.makeText(GsonActivity.this,stringList.size()+"",Toast.LENGTH_SHORT).show();
    }

    /**
     * GsonBuilder用法
     */

    private void gsonBuilder(){
        Gson gson = new GsonBuilder()
                //序列化null
                .serializeNulls()
                // 设置日期时间格式，另有2个重载方法
                // 在序列化和反序化时均生效
                .setDateFormat("yyyy-MM-dd")
                // 禁此序列化内部类
                .disableInnerClassSerialization()
                //生成不可执行的Json（多了 )]}' 这4个字符）
                .generateNonExecutableJson()
                //禁止转义html标签
                .disableHtmlEscaping()
                //格式化输出
                .setPrettyPrinting()
                .create();
        User user = new User("怪盗kidou","","");
        Toast.makeText(GsonActivity.this,gson.toJson(user),Toast.LENGTH_SHORT).show();
    }
}
