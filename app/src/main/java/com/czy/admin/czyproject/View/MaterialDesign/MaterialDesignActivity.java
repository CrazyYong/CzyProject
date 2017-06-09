package com.czy.admin.czyproject.View.MaterialDesign;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.czy.admin.czyproject.R;

/**
 * Created by czy on 2017/6/8.
 */

public class MaterialDesignActivity extends Activity {
    private TextInputLayout textInputLayout;
    private EditText editText,input_editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_layout);
        textInputLayout = (TextInputLayout) findViewById(R.id.textInputLayout);
        textInputLayout.setHint("请输入4位学号");
        editText = (EditText) findViewById(R.id.editText);
        input_editText=(EditText)findViewById(R.id.input_editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 4) {
                    textInputLayout.setError("学号输入错误");
                    textInputLayout.setErrorEnabled(true);
                } else {
                    textInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        input_editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 4) {
                    input_editText.setError("学号输入错误");
//                    textInputLayout.setError("学号输入错误");
//                    textInputLayout.setErrorEnabled(true);
                } else {
//                    textInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}