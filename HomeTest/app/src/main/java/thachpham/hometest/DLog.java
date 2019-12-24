package thachpham.hometest;

import android.util.Log;

public class DLog {
    static boolean mIsDebug = true;
    static String mTag = "mytag";

    public static void print(String msg) {
        if (mIsDebug) {
            Log.i(mTag, msg);
        }
    }
}
