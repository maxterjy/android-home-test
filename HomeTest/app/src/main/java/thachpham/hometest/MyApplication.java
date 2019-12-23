package thachpham.hometest;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("kkk", "application oncreate");
        mContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return mContext;
    }
}
