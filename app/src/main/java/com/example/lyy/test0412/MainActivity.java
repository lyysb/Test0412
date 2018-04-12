package com.example.lyy.test0412;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

/*
客户端
 */
public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, AdvertManagerService.class);

        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);

    }
    private ServiceConnection mConnection = new ServiceConnection() {

        @Override

        public void onServiceConnected(ComponentName name, IBinder service) {

            //这里将binder对象转换为aidl对象，从而能够调用aidl方法。

            IAdvertManager iAdvertManager = IAdvertManager.Stub.asInterface(service);

            try {

                mAdvertManager = iAdvertManager;

                List advertList = mAdvertManager.getAdvertList();

                //得到广告列表之后就可以为所欲为了。。。。

                Log.i(TAG,advertList.toString());

                Advert advert = new Advert("java", 10, "后台");

                mAdvertManager.addAdvert(advert);

                Log.i(TAG,iAdvertManager.getAdvertList().toString());

            } catch (RemoteException e) {

                e.printStackTrace();

            }

        }

        @Override

        public void onServiceDisconnected(ComponentName name) {

        }

    };

    @Override

    protected void onDestroy() {

        //最后解注册

        unbindService(mConnection);

        super.onDestroy();

    }



}
