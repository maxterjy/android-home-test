package thachpham.hometest.mainmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import thachpham.hometest.DLog;
import thachpham.hometest.R;
import thachpham.hometest.databinding.ItemHotkeyBinding;

public class HotkeyAdapter extends RecyclerView.Adapter<HotkeyAdapter.ItemViewHolder> {
    List<String> mHotkeys;

    public HotkeyAdapter(List<String> hotkeys) {
        mHotkeys = hotkeys;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemHotkeyBinding itemBinding = ItemHotkeyBinding.inflate(inflater, parent, false);

        ItemViewHolder holder = new ItemViewHolder(itemBinding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        DLog.print("onBindViewHolder " + mHotkeys.get(position));
        holder.mBinding.tvKey.setText(mHotkeys.get(position));
    }

    @Override
    public int getItemCount() {
        return mHotkeys.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ItemHotkeyBinding mBinding;

        public ItemViewHolder(@NonNull ItemHotkeyBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }
}
