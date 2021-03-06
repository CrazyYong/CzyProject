package com.czy.admin.czyproject.NetWork.HttpConnection;

import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by czy on 2017/3/13.
 */

public class HttpUtil implements HttpResultInterface {

    public static final String WAN_ANDROID_URL = "http://www.wanandroid.com/banner/json";
    public static final String XML_URL="http://app.cheyooh.com/i.ashx?m=ad_home_banner&uid=f09d02040e7842ceaf1591a66f014d67&location_cityid=95&ver=4.3.0&channel=C172%E4%B9%90%E8%A7%86%E5%95%86%E5%BA%97v4.3.1&key=db3544284f0e6cab65dfadd51f12e2c3&tagversion=va&checkKey=e18de8c8a5adf7eee51204f46f09963a&timestamp=0";
    public static final String GIT_GSON="https://api.github.com";
    public static final String WEATHER_GSON="http://api.k780.com:88/?app=weather.future&weaid=1&&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json";
    private HttpResultInterface resultInterface =null;


   public  HttpUtil(HttpResultInterface resultInterface){
       this.resultInterface = resultInterface;
   }



    public  void requestData(){
        testHttpConnection();
    }



    public void returnData (String name){

    }


    private  void testHttpConnection(){
    try {
    URL url = new URL(WAN_ANDROID_URL);
    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
    httpURLConnection.connect();
    httpURLConnection.setConnectTimeout(4000);
    httpURLConnection.setReadTimeout(4000);
    InputStream inputStream = httpURLConnection.getInputStream();
    byte data[] = new byte[256];
     inputStream.read(data);//InputString流读到data中
        String message = new String(data);//将data转换为String类型
        resultInterface.returnData(message);
        Log.i("CZYAPP",message);
        httpURLConnection.disconnect();
   }catch (Exception e){

        }
    }

    private  InputStream testHttpConnectionBySAX(){
        InputStream inputStream=null;
        try {
            URL url = new URL(WAN_ANDROID_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            httpURLConnection.setConnectTimeout(4000);
            httpURLConnection.setReadTimeout(4000);
            inputStream = httpURLConnection.getInputStream();
            byte data[] = new byte[256];
            inputStream.read(data);//InputString流读到data中
            String message = new String(data);//将data转换为String类型
            resultInterface.returnData(message);
        }catch (Exception e){

        }

        return inputStream;
    }



}
