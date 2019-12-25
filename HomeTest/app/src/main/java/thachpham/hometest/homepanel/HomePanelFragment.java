package thachpham.hometest.homepanel;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import thachpham.hometest.databinding.FragmentPanelHomeBinding;
import thachpham.hometest.homepanel.category.CategoryViewModel;

public abstract class HomePanelFragment extends Fragment {

    protected abstract Class<? extends HomePanelViewModel> getViewModelClassType();

    FragmentPanelHomeBinding mBinding;
    HomePanelViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(getViewModelClassType());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentPanelHomeBinding.inflate(inflater, container, false);

        mViewModel.getCategories().observe(this, new Observer<List<UrlMenuItem>>() {
            @Override
            public void onChanged(List<UrlMenuItem> categoryItems) {
                mBinding.recyclerviewCategory.setAdapter( new HomePanelAdapter(categoryItems));
            }
        });

        return mBinding.getRoot();
    }

}
