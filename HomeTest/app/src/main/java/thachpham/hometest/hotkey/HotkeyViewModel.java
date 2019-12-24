package thachpham.hometest.hotkey;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import thachpham.hometest.DLog;
import thachpham.hometest.MyApplication;

public class HotkeyViewModel extends ViewModel {

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
        final List<String> wordlist = new ArrayList<String>();

        RequestQueue queue = Volley.newRequestQueue(MyApplication.getAppContext());
        String url = "https://raw.githubusercontent.com/tikivn/android-home-test/v2/keywords.json";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArr = new JSONArray(response);

                            for(int i = 0; i < jsonArr.length(); ++i) {
                                String word = jsonArr.getString(i);
                                wordlist.add(word);
                            }

                        } catch (JSONException e) {
                            DLog.print("fetchHotkeys parse, exception: " + e);
                            e.printStackTrace();
                        }

                        mHotKeys.setValue(wordlist);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        DLog.print("onErrorResponse: " + error);
                    }
                }
        );

        queue.add(stringRequest);
    }

}
