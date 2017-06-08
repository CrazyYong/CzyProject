package com.czy.admin.czyproject.View.Fragment.FragmentDialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.czy.admin.czyproject.R;

/**
 * Created by czy on 2017/6/7.
 */

public class FragmentDialogActivity extends Activity implements LoginDialogFragment.LoginInputListener {
    private Button btn_edit,btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dialog_main);
        btn_edit=(Button)findViewById(R.id.btn_edit);
        btn_login=(Button)findViewById(R.id.btn_login);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditNameDialogFragment editNameDialog = new EditNameDialogFragment();
                editNameDialog.show(getFragmentManager(), "EditNameDialog");
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginDialogFragment dialog = new LoginDialogFragment();
                dialog.show(getFragmentManager(), "loginDialog");
            }
        });
    }

    @Override
    public void onLoginInputComplete(String username, String password) {
        Toast.makeText(this, "帐号：" + username + ",  密码 :" + password,
                Toast.LENGTH_SHORT).show();
    }
}
