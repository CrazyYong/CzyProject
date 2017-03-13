package com.czy.admin.czyproject.Http;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cmx on 2017/3/13.
 */

public class HttpUtil implements HttpResultInterface {

    private static final String REMOTE_CONFIG_URL_GAMEPAD1 = "http://211.170.59.204:18080/ota/company/innoplay/project/tim/device/gamepad1/firmware/latest";
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
    URL url = new URL(REMOTE_CONFIG_URL_GAMEPAD1);
    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
    httpURLConnection.connect();
    httpURLConnection.setConnectTimeout(4000);
    httpURLConnection.setReadTimeout(4000);
    InputStream inputStream = httpURLConnection.getInputStream();
    byte data[] = new byte[256];
     inputStream.read(data);//InputString流读到data中
        String message = new String(data);//将data转换为String类型
        resultInterface.returnData(message);

   }catch (Exception e){

        }


    }
}
