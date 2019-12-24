package thachpham.hometest.mainmenu;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import thachpham.hometest.DLog;
import thachpham.hometest.R;
import thachpham.hometest.databinding.FragmentMainMenuBinding;

public class MainMenuFragment extends Fragment {

    MainMenuViewModel mViewModel;
    FragmentMainMenuBinding mBinding;

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

                HotkeyAdapter adapter = new HotkeyAdapter(hotkeys);
                mBinding.recyclerviewHotkeys.setAdapter(adapter);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_menu, container, false);

        return mBinding.getRoot();
    }

}
