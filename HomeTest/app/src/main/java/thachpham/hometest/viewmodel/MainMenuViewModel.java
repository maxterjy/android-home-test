package thachpham.hometest.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainMenuViewModel extends ViewModel {

    private MutableLiveData<List<String>> mHotKeys = null;

    public LiveData<List<String>> getHotKeys() {
        if (mHotKeys == null) {
            mHotKeys = new MutableLiveData<List<String>>();

            fetchHotkeys();
        }

        return mHotKeys;
    }

    private void fetchHotkeys() {
        Log.i("kkk", "fetchHotkeys");
        List<String> ll = new ArrayList<String>();
        ll.add("abc");
        ll.add("def");
        ll.add("ghi");

        mHotKeys.setValue(ll);
    }

}
