package com.czy.admin.czyproject.FileOperate;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.czy.admin.czyproject.R;

/**
 * Created by czy on 2017/4/25.
 */

public class FileOperateActivity extends Activity {

    private EditText mPathName;
    private EditText mFileName;
    private EditText mContent;
    private Button mTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_operate);
        findid();
        mTest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getcontent();
            }
        });
    }

    private void findid() {
        mPathName = (EditText) findViewById(R.id.et_pathName);
        mFileName = (EditText) findViewById(R.id.et_fileName);
        mContent = (EditText) findViewById(R.id.et_content);
        mTest = (Button) findViewById(R.id.btn_test);
    }

    private void getcontent() {
        String pathName = mPathName.getText().toString();
        String fileName = mFileName.getText().toString();
        String content = mContent.getText().toString();
        if (TextUtils.isEmpty(pathName)) {
            Toast.makeText(this, "文件夹名不能为空", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(fileName)) {
            Toast.makeText(this, "文件名不能为空", Toast.LENGTH_SHORT).show();
        } else {
            Tool tool = new Tool();
            String filePath = Environment.getExternalStorageDirectory()
                    .getPath() + "/" + pathName + "/";
            String fileName1 = fileName + ".txt";

            tool.writeTxtToFile(content, filePath, fileName1);// 将字符串写入到文本文件中
            Toast.makeText(this, "创建成功", Toast.LENGTH_SHORT).show();
        }
    }
}