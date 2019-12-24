package thachpham.hometest.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import thachpham.hometest.DLog;
import thachpham.hometest.R;
import thachpham.hometest.viewmodel.MainMenuViewModel;

public class MainMenuFragment extends Fragment {

    MainMenuViewModel mViewModel;

    public MainMenuFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainMenuViewModel.class);

        mViewModel.getHotKeys().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> hotkeys) {
                DLog.print("onChanged " + hotkeys.size());
                for(int i = 0; i < hotkeys.size(); ++i) {
                    DLog.print("ui key: " + hotkeys.get(i));
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main_menu, container, false);
    }

}
