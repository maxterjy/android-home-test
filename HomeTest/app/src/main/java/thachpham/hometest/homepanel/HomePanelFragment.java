package thachpham.hometest.homepanel.category;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import thachpham.hometest.databinding.FragmentCategoryBinding;
import thachpham.hometest.homepanel.HomePanelAdapter;
import thachpham.hometest.homepanel.TitleUrlPair;
import thachpham.hometest.homepanel.HomePanelViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    FragmentCategoryBinding mBinding;
    HomePanelViewModel mViewModel;

    public CategoryFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentCategoryBinding.inflate(inflater, container, false);

        mViewModel.getCategories().observe(this, new Observer<List<TitleUrlPair>>() {
            @Override
            public void onChanged(List<TitleUrlPair> categoryItems) {
                mBinding.recyclerviewCategory.setAdapter(new HomePanelAdapter(categoryItems));
            }
        });

        return mBinding.getRoot();
    }

}
