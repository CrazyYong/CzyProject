package com.czy.admin.czyproject.Http;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.czy.admin.czyproject.Http.SAX.SaxService;
import com.czy.admin.czyproject.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

/**
 * Created by czy on 2017/3/13.
 */

public class HttpActivity extends Activity implements HttpResultInterface {
    private Button btn_test;
    private Button btn_sax;
    private Button btn_download;
    private HttpUtil httpUtil =null;
    private static  String PATH;
    private static final String NEWGAMEPADE ="newremote.bin";
    private static final String NEWDONGLE ="newdongle.bin";
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    String message = (String) msg.obj;
                    Toast.makeText(HttpActivity.this, message + "", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        PATH = HttpActivity.this.getCacheDir()+"/firmware/";
        btn_test = (Button) findViewById(R.id.btn_test);
        btn_sax=(Button)findViewById(R.id.btn_sax);
        btn_download=(Button)findViewById(R.id.btn_download);
        httpUtil = new HttpUtil(this);

        btn_sax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
              try{
                        URL url = new URL(HttpUtil.XML_URL);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.connect();
                        httpURLConnection.setConnectTimeout(4000);
                        httpURLConnection.setReadTimeout(4000);
                        InputStream inputStream = httpURLConnection.getInputStream();
                 List<HashMap<String,String>> list = SaxService.readXML(inputStream,"ad");
              for(HashMap<String,String>map:list){
                  Log.i("CZYAPP",map.get("ad_code"));
              }
                    }catch (Exception e){

                    }



                    }
                }).start();
            }
        });

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        httpUtil.requestData();

                    }
                }).start();
            }
        });

        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getfile("http://ota.gamepadota.com:18081/file/firmware/21",1);
            }
        });
    }

    public void returnData(String name){
        Message msg = handler.obtainMessage();
        msg.obj = name;
        msg.what = 1;
        handler.sendMessage(msg);

    }


    private void getfile(String downurl,int padnum)
    {
        try
        {
            int count=0;
            URL url = new URL(downurl);

            HttpURLConnection conection = (HttpURLConnection) url.openConnection();
            conection.connect();
            conection.setConnectTimeout(4000);
            conection.setReadTimeout(4000);

            // download the file
            InputStream input = conection.getInputStream();
            File dir = new File(PATH);
            File file = null;
            if (padnum==1) {
                //下载手柄的bin文件
                file = new File(PATH+NEWGAMEPADE);
            }else {
                //下载dongle的bin文件
                file=new File(PATH+NEWDONGLE);
            }
            if (!dir.exists())
                dir.mkdir();
            if (file.exists())
                file.delete();
            // Output stream
            OutputStream output = new FileOutputStream(file);

            byte data[] = new byte[256];
            do
            {
                count = input.read(data);
                if (count==-1) {
                    break;
                }
                output.write(data, 0, count);
            } while (true);


            // flushing output
            output.flush();

            // closing streams
            output.close();
            input.close();
        } catch (Exception e)
        {

        }

    }


}
