package me.dahei.aidltest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * created by yubosu
 * 2018年07月31日下午3:14
 */
public class TesterActivity extends AppCompatActivity {

    private static final String TAG = "TesterActivity";
    private static final String SERVICE＿PACKAGE = "me.dahei.aidltest";
    private static final String SERVICE＿ACTION = "me.dahei.aidltest.service";

    private boolean mBound;
    IMyAidlInterface myService;
    Button aidlBtn;


    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myService = IMyAidlInterface.Stub.asInterface(service);// 获取服务对象
            aidlBtn.setEnabled(true);
            Log.d(TAG, "connect");
        }// 连接服务

        @Override
        public void onServiceDisconnected(ComponentName name) {

            Log.d(TAG, "disconnect");
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        // Unbind from the service
        if (mBound) {
            unbindService(serviceConnection);
            mBound = false;
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tester);
        Intent intent = new Intent(this,MyService.class);
        aidlBtn =  findViewById(R.id.btnAidl);
//        intent.setComponent(new ComponentName(SERVICE＿PACKAGE, SERVICE＿ACTION));
        boolean start = bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        Log.d("TesterActivity", "start = " + start);
        mBound = true;
        aidlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String job = myService.getJob(23, 1, "bill gates");
                    Toast.makeText(TesterActivity.this, job, Toast.LENGTH_LONG).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
