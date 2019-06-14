package com.czy.admin.czyproject.View.customView.bezier;

import android.app.Activity;
import android.os.Bundle;

import com.czy.admin.czyproject.R;
/**
 * @author Create by cpSir on 2019/6/14
 */
public class BezierActivity extends Activity {
    private Bezier2 btn_bezier2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier);

        Bezier2 btn_bezier2 =(Bezier2) findViewById(R.id.btn_bezier2);
    }
}
