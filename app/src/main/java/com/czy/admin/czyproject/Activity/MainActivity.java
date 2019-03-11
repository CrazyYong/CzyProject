package com.czy.admin.czyproject.Activity;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.czy.admin.czyproject.ContentProvider.ContentProviderActivity;
import com.czy.admin.czyproject.FileOperate.FileOperateActivity;
import com.czy.admin.czyproject.FourComponents.FourComponents;
import com.czy.admin.czyproject.Gson.GsonActivity;
import com.czy.admin.czyproject.IPC.IPCActivity;
import com.czy.admin.czyproject.jetPack.JetPackActivity;
import com.czy.admin.czyproject.jetPack.dataBinding.DataBindingActivity;
import com.czy.admin.czyproject.Proprety.PropretyActivity;
import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.Reflect.ReflectActivity;
import com.czy.admin.czyproject.RxJava.RxJavaActivity;
import com.czy.admin.czyproject.Utils.UtilsTool;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button main_rxjava_btn,main_gson_btn,main_create_file_btn
           ,main_content_btn
            ,main_view_btn,main_newwork_btn,main_thread_btn,main_proprety_btn,main_components_btn,main_ipc_btn,main_reflect,main_jetpack;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        main_rxjava_btn=(Button)findViewById(R.id.main_rxjava_btn);
        main_gson_btn=(Button)findViewById(R.id.main_gson_btn);
        main_create_file_btn=(Button)findViewById(R.id.main_create_file_btn);
        main_content_btn=(Button)findViewById(R.id.main_content_btn);
        main_view_btn=(Button)findViewById(R.id.main_view_btn);
        main_newwork_btn=(Button)findViewById(R.id.main_newwork_btn);
        main_thread_btn=(Button)findViewById(R.id.main_thread_btn);
        main_proprety_btn=(Button)findViewById(R.id.main_proprety_btn);
        main_components_btn=(Button)findViewById(R.id.main_components_btn);
        main_ipc_btn=(Button)findViewById(R.id.main_ipc_btn);
        main_reflect=(Button)findViewById(R.id.main_reflect);
        main_jetpack=(Button)findViewById(R.id.main_jetpack);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main_rxjava_btn.setOnClickListener(this);
        main_gson_btn.setOnClickListener(this);
        main_create_file_btn.setOnClickListener(this);
        main_content_btn.setOnClickListener(this);
        main_view_btn.setOnClickListener(this);
        main_newwork_btn.setOnClickListener(this);
        main_thread_btn.setOnClickListener(this);
        main_proprety_btn.setOnClickListener(this);
        main_components_btn.setOnClickListener(this);
        main_ipc_btn.setOnClickListener(this);
        main_reflect.setOnClickListener(this);
        main_jetpack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_rxjava_btn:
                UtilsTool.goActivity(this,RxJavaActivity.class);
                break;
            case R.id.main_gson_btn:
                UtilsTool.goActivity(this,GsonActivity.class);
                break;
            case R.id.main_create_file_btn:
                UtilsTool.goActivity(this,FileOperateActivity.class);
                break;
            case R.id.main_content_btn:
                UtilsTool.goActivity(this,ContentProviderActivity.class);
                break;
            case R.id.main_view_btn:
                UtilsTool.goActivity(this,ViewActivity.class);
                break;
            case R.id.main_newwork_btn:
                UtilsTool.goActivity(this,NetWorkActivity.class);
                break;
            case R.id.main_thread_btn:
                UtilsTool.goActivity(this,ThreadWorkActivity.class);
                break;
            case R.id.main_proprety_btn:
                UtilsTool.goActivity(this,PropretyActivity.class);
                break;
            case R.id.main_components_btn:
                UtilsTool.goActivity(this, FourComponents.class);
                break;
            case R.id.main_ipc_btn:
                UtilsTool.goActivity(this, IPCActivity.class);
                break;
            case R.id.main_reflect:
                UtilsTool.goActivity(this, ReflectActivity.class);
                break;
            case R.id.main_jetpack:
//                UtilsTool.goActivity(this, LiveDataActivity.class);
//                downLoadAPK(this,"http://p.gdown.baidu.com/6690dbdfc1ec1b2a44d7047089225d5f8de87ce8a4b6d1aa2ca3e0bffee766b6aa2de6792ed9aae8541f756597fbfc1e43fda875ff76ed687fff3f50d2f62bc110b45ef8c0ec238732d815740dc7464f4d09c41401953ad976f1d88575397c032422e8f437202bbfb08eb346451241f68ce435cfd48aeef050d85384ef6468f3e140b6f46ec18a662633aa1dae4e6216bf26e6bae17ad789485153143b858f4d29a80b68c8f80538d5ad80c94ad8e3ef8f56594177cd20a34f263cc51680fe296199405d641cd495d526105eb5e9e34ccaba691f71e7a8e9263f4dd61f72f7f93446996fc4182325cb325b4e7c3f3bc1141cf0cf4368df615f814db4ecf25a81a219f3fdfaf627f6d503f612b9217a71c55f385919ebe3ec37f88daba8e81b49be97c6a53984cf8680285b7c7beaffdeb650c6d51dda6efdb92964621e03c7fcda733f5fbd74b54b");
                int version ="1.0.3".compareTo("1.0.4");
//                Log.i("CZYAPP",updateApp("1.2.6","1.2.7")+"");
//                Log.i("CZYAPP", updateApp2("1.5.6","1.0")+"");
                UtilsTool.goActivity(this, JetPackActivity.class);
                break;
            default:
                break;

        }
    }


    private void sendMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


    public boolean updateApp2(String localVersion, String newVersion){
        String[] localVersionArray = localVersion.split("\\.");
        String[] newVersionArray = newVersion.split("\\.");

        localVersion = sp(localVersionArray);
        newVersion = sp(newVersionArray);

        if (localVersion.length()<newVersion.length()){
            int cha = newVersion.length()-localVersion.length();
            for (int i=0;i<cha;i++){
                localVersion=localVersion+"0";
            }
        }else{
            int cha = localVersion.length()-newVersion.length();
            for (int i=0;i<cha;i++){
                newVersion=newVersion+"0";
            }
        }

        Integer localVersionInt = Integer.valueOf(localVersion);
        Integer newVersionInt = Integer.valueOf(newVersion);


        if (localVersionInt<newVersionInt){
            return true;
        }else {
            return false;
        }
    }


    public boolean updateApp(String localVersion, String newVersion) {
        String[] localVersionArray = localVersion.split("\\.");
        String[] newVersionArray = newVersion.split("\\.");

        if (localVersionArray.length < newVersionArray.length) {
            int cha = newVersionArray.length - localVersionArray.length;
            for (int i = 0; i < cha; i++) {
                localVersion = localVersion + ".0";
            }
            localVersionArray = localVersion.split("\\.");
            Log.i("CZYAPP","1111111");
        }else{
            int cha = localVersionArray.length - newVersionArray.length;
            Log.i("CZYAPP","222222:"+cha);
            for (int i = 0; i < cha; i++) {
                newVersion = newVersion + ".0";
            }
            newVersionArray = newVersion.split("\\.");


        }

        try {

            Integer localVersionInt = Integer.valueOf(sp(localVersionArray));
            Integer newVersionInt = Integer.valueOf(sp(newVersionArray));
            Log.i("CZYAPP","localVersionInt:"+localVersionInt+"--newVersionInt:"+newVersionInt);

            if (localVersionInt<newVersionInt){
                return true;
            }else {
                return false;
            }

//            for (int i = 0; i < newVersionArray.length; i++) {
//                int temp = Integer.parseInt(newVersionArray[i]);
//                int compar = Integer.parseInt(localVersionArray[i]);
//                if (temp > compar) {
//                    return true;
//                }
//
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String sp(String[] strs) {
        StringBuffer s = new StringBuffer();
        for (String s1 :strs){
            s.append(s1);
        }
            return s.toString();
    }



    /**
     * 下载新版本
     *
     * @param context
     * @param url
     */
    public static void downLoadAPK(Context context, String url) {

        if (TextUtils.isEmpty(url)) {
            return;
        }

        try {
            String serviceString = Context.DOWNLOAD_SERVICE;
            final DownloadManager downloadManager = (DownloadManager) context.getSystemService(serviceString);

            Uri uri = Uri.parse(url);
            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.allowScanningByMediaScanner();
            request.setVisibleInDownloadsUi(true);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setMimeType("application/vnd.android.package-archive");
            request.setDestinationInExternalPublicDir(Environment.getExternalStorageDirectory().getAbsolutePath()+"/chenzhiyong/", "chenzhiyong.apk");
            request.setTitle("正在下载...");
            long refernece = downloadManager.enqueue(request);
            Log.i("CZYAPP","下载文件id:"+refernece);
        } catch (Exception exception) {
            Log.i("CZYAPP","更新失败");
        }

    }

}
