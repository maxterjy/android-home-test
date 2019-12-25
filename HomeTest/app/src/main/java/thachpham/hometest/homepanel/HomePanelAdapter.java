package thachpham.hometest.homepanel;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import thachpham.hometest.databinding.ViewholderCategoryBinding;
import thachpham.hometest.util.DLog;

public class TextImageAdapter extends RecyclerView.Adapter<TextImageAdapter.CategoryViewHolder> {
    List<TextImageItem> mItems;

    public TextImageAdapter(List<TextImageItem> categoryItems) {
        mItems = categoryItems;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewholderCategoryBinding binding = ViewholderCategoryBinding.inflate(inflater, parent, false);

        TextImageAdapter.CategoryViewHolder holder = new TextImageAdapter.CategoryViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.mBinding.tvCategoryTitle.setText(mItems.get(position).getTitle());

        DLog.print("imageUrl: " + mItems.get(position).getImageUrl());

        Glide.with(holder.itemView)
                .load(mItems.get(position).getImageUrl())
                .into(holder.mBinding.iconCategory);
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
