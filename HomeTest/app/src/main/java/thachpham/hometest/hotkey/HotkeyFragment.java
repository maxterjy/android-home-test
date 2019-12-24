package thachpham.hometest.hotkey;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import thachpham.hometest.databinding.FragmentHotkeyBinding;

public class HotkeyFragment extends Fragment {

    HotkeyViewModel mViewModel;
    FragmentHotkeyBinding mBinding;

    public HotkeyFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HotkeyViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentHotkeyBinding.inflate(inflater, container, false);

        mViewModel.getHotKeys().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> hotkeys) {
                HotkeyAdapter adapter = new HotkeyAdapter(hotkeys);
                mBinding.recyclerviewHotkeys.setAdapter(adapter);
            }
        });

        return mBinding.getRoot();
    }

}
