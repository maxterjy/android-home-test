package thachpham.hometest.category;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import thachpham.hometest.R;
import thachpham.hometest.databinding.FragmentCategoryBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    FragmentCategoryBinding mBinding;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentCategoryBinding.inflate(inflater, container, false);
        mBinding.recyclerviewCategory.setAdapter(new CategoryAdapter());

        return mBinding.getRoot();
    }

}
