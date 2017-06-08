package com.czy.admin.czyproject.ContentProvider;

import android.app.Activity;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.czy.admin.czyproject.R;
import com.google.gson.Gson;

/**
 * Created by czy on 2017/6/5.
 */

public class ContentProviderActivity extends Activity {
    private Button btn_write,btn_read;
    private TextView tv_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        btn_write=(Button)findViewById(R.id.btn_write);
        btn_read=(Button)findViewById(R.id.btn_read);
        tv_show=(TextView)findViewById(R.id.tv_show);

        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json =gsonToGson("dongle","open");
                senToContent(ContentProviderActivity.this,"dongle",json);
            }
        });

        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query();
            }
        });
    }

    public static String  gsonToGson( String name, String status){
        Gson gson = new Gson();
        TelemetryBean telemetryBean = new TelemetryBean(name,status);
        String jsonString = gson.toJson(telemetryBean);
        return jsonString;
    }

    /**
     * @param context
     * @param key
     * @param json
     */
    public static void senToContent(Context context, String key, String json){
        Uri target = Uri.parse("content://timvision.telemetry/traps");
        ContentValues values = new ContentValues();
        values.put(key, json);
        ContentProviderClient providerClient = context.getContentResolver().acquireContentProviderClient(target);
        if (providerClient != null) {
            try {
                providerClient.insert(target, values);
            } catch (RemoteException e) {

            }

        }
    }

    private void query() {
        String columns[] = new String[]{"app"};
        Uri target = Uri.parse("content://timvision.telemetry/traps");
        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(target, columns, null, null,
                null);

     if(c.moveToFirst()){
         String name = c.getString(c.getColumnIndex("name"));
         tv_show.setText(name);
     }

    }

}
