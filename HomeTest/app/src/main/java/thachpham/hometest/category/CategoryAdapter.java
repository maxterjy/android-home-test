package thachpham.hometest.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import thachpham.hometest.databinding.ViewholderCategoryBinding;
import thachpham.hometest.databinding.ViewholderHotkeyBinding;
import thachpham.hometest.hotkey.HotkeyAdapter;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    List<CategoryItem> mItems;

    public CategoryAdapter(List<CategoryItem> categoryItems) {
        mItems = categoryItems;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewholderCategoryBinding binding = ViewholderCategoryBinding.inflate(inflater, parent, false);

        CategoryAdapter.CategoryViewHolder holder = new CategoryAdapter.CategoryViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.mBinding.tvCategoryTitle.setText(mItems.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        ViewholderCategoryBinding mBinding;

        public CategoryViewHolder(@NonNull ViewholderCategoryBinding binding) {
            super(binding.getRoot());

            mBinding = binding;
        }
    }
}
