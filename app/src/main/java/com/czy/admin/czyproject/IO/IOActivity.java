package com.czy.admin.czyproject.IO;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.czy.admin.czyproject.R;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by admin on 2018/7/29.
 */

public class IOActivity extends Activity implements View.OnClickListener{
    private Button io_read_file_btn;
    private TextView io_txt_dis;
    Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    String result=msg.obj.toString();
                    io_txt_dis.setText(result);
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_io);
        io_read_file_btn=(Button)findViewById(R.id.io_read_file_btn);
        io_txt_dis=(TextView)findViewById(R.id.io_txt_dis);
        io_read_file_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            switch (view.getId()){
                 case R.id.io_read_file_btn:
                       readFromLocalFile();
                        break;
      }
    }

    /**
     * 读取指定文件的内容
     * @param filePath ： 文件的路径
     * @return  返回的结果
     */
    public String readFile( String filePath ){
        FileInputStream fis=null;
        String result = "" ;
        try {
            // 根据path路径实例化一个输入流的对象
            fis  = new FileInputStream( filePath );

            //2. 返回这个输入流中可以被读的剩下的bytes字节的估计值；
            int size =  fis.available() ;
            //3. 根据输入流中的字节数创建byte数组；
            byte[] array = new byte[size];
            //4.把数据读取到数组中；
            fis.read( array ) ;

            //5.根据获取到的Byte数组新建一个字符串，然后输出；
            result = new String(array);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            if ( fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result ;
    }

    /**
     * 根据指定文件路径读取本地文件内容
     */
    private void readFromLocalFile() {
        //1.读取raw下的文件转化为InputStream输入流
        InputStream inputStream = getResources().openRawResource(R.raw.test);
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "gbk");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer sb = new StringBuffer("");
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }

            Message msg = Message.obtain();
            msg.what = 1;
            msg.obj = sb;
            handler.sendMessage(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
