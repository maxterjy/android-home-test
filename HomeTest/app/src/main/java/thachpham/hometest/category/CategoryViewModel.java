package thachpham.hometest.category;

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
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import thachpham.hometest.util.DLog;
import thachpham.hometest.MyApplication;
import thachpham.hometest.util.TextFormatter;

public class CategoryViewModel extends ViewModel {
    private MutableLiveData<List<CategoryItem>> mCategories = null;

    public LiveData<List<CategoryItem>> getCategories() {
        if (mCategories == null) {
            mCategories = new MutableLiveData<List<CategoryItem>>();

            fetchCategories();
        }

        return mCategories;
    }

    private void fetchCategories() {
        final List<CategoryItem> list = new ArrayList<CategoryItem>();

        RequestQueue queue = Volley.newRequestQueue(MyApplication.getAppContext());
        String url = "https://raw.githubusercontent.com/maxterjy/android-home-test/master/online-data/category.json";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArr = new JSONArray(response);

                            for(int i = 0; i < jsonArr.length(); ++i) {
                                JSONObject obj = jsonArr.getJSONObject(i);
                                String title = obj.getString("title");
                                String imageUrl = obj.getString("image");

                                String formattedTitle = TextFormatter.getTwoLineFormat(title);

                                list.add(new CategoryItem(formattedTitle, imageUrl));
                            }

                        } catch (JSONException e) {
                            DLog.print("fetchCategories parse, exception: " + e);
                            e.printStackTrace();
                        }

                        mCategories.setValue(list);
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
