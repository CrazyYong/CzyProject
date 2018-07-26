package com.czy.admin.czyproject.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.czy.admin.czyproject.ContentProvider.ContentProviderActivity;
import com.czy.admin.czyproject.FileOperate.FileOperateActivity;
import com.czy.admin.czyproject.FourComponents.FourComponents;
import com.czy.admin.czyproject.Gson.GsonActivity;
import com.czy.admin.czyproject.IPC.IPCActivity;
import com.czy.admin.czyproject.IPC.Messager.MessengerActivity;
import com.czy.admin.czyproject.Proprety.PropretyActivity;
import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.RxJava.RxJavaActivity;
import com.czy.admin.czyproject.Utils.UtilsTool;

import java.io.File;
import java.util.List;

import ru.bartwell.exfilepicker.ExFilePicker;
import ru.bartwell.exfilepicker.data.ExFilePickerResult;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button main_rxjava_btn,main_gson_btn,main_create_file_btn
           ,main_content_btn
            ,main_view_btn,main_newwork_btn,main_thread_btn,main_proprety_btn,main_components_btn,main_ipc_btn;

    private MainActivity mActivity;
    private final int EX_FILE_PICKER_RESULT = 0xfa01;
    private String startDirectory = null;// 记忆上一次访问的文件目录路径
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_rxjava_btn:
//                UtilsTool.goActivity(this,RxJavaActivity.class);
                ExFilePicker exFilePicker = new ExFilePicker();
                exFilePicker.setCanChooseOnlyOneItem(true);// 单选
                exFilePicker.setShowOnlyExtensions(".dat");
                exFilePicker.setQuitButtonEnabled(true);

                if (TextUtils.isEmpty(startDirectory)) {
                    exFilePicker.setStartDirectory(Environment.getExternalStorageDirectory().getPath());
                } else {
                    exFilePicker.setStartDirectory(startDirectory);
                }

                exFilePicker.setChoiceType(ExFilePicker.ChoiceType.FILES);
                exFilePicker.start(mActivity, EX_FILE_PICKER_RESULT);
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
            default:
                break;

        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == EX_FILE_PICKER_RESULT) {
            ExFilePickerResult result = ExFilePickerResult.getFromIntent(data);
            if (result != null && result.getCount() > 0) {
                String path = result.getPath();

                List<String> names = result.getNames();
                for (int i = 0; i < names.size(); i++) {
                    File f = new File(path, names.get(i));
                    try {
                        Uri uri = Uri.fromFile(f); //这里获取了真实可用的文件资源
                        Toast.makeText(mActivity, "选择文件:" + uri.getPath(), Toast.LENGTH_SHORT)
                                .show();

                        startDirectory = path;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
