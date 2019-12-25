package thachpham.hometest.homepanel;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import thachpham.hometest.databinding.ViewholderUrlmenuItemBinding;
import thachpham.hometest.util.DLog;

public class HomePanelAdapter extends RecyclerView.Adapter<HomePanelAdapter.CategoryViewHolder> {
    List<UrlMenuItem> mItems;

    public HomePanelAdapter(List<UrlMenuItem> categoryItems) {
        mItems = categoryItems;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewholderUrlmenuItemBinding binding = ViewholderUrlmenuItemBinding.inflate(inflater, parent, false);

        HomePanelAdapter.CategoryViewHolder holder = new HomePanelAdapter.CategoryViewHolder(binding);
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
        ViewholderUrlmenuItemBinding mBinding;

        public CategoryViewHolder(@NonNull ViewholderUrlmenuItemBinding binding) {
            super(binding.getRoot());

            mBinding = binding;
        }
    }

    public void setItemList(List<UrlMenuItem> itemList) {
        mItems = itemList;
    }
}
