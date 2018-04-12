package com.example.lyy.test0412;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by LYY on 2018/4/12.
 * 服务端
 */

public class AdvertManagerService extends Service {


    private CopyOnWriteArrayList mAdvertList = new CopyOnWriteArrayList<>();

    //核心，Stub里面的方法运行的binder池中。
    private Binder mBinder = new IAdvertManager.Stub(){


        public List getAdvertList() throws RemoteException {

            return mAdvertList;

        }


        public void addAdvert(Advert ad) throws RemoteException {

            mAdvertList.add(ad);

        }

    };



    @Nullable

    @Override

    public IBinder onBind(Intent intent) {

        return mBinder;

    }

    @Override

    public void onCreate() {

        super.onCreate();

        mAdvertList.add(new Advert("Android", 10, "app开发"));

        mAdvertList.add(new Advert("ios", 10, "ios开发"));

    }



}
