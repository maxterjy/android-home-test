package thachpham.hometest.mainmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import thachpham.hometest.DLog;
import thachpham.hometest.R;
import thachpham.hometest.databinding.ItemHotkeyBinding;

public class HotkeyAdapter extends RecyclerView.Adapter<HotkeyAdapter.ItemViewHolder> {
    List<String> mHotkeys;

    public HotkeyAdapter(List<String> hotkeys) {
        mHotkeys = getFormattedHotkeys(hotkeys);
    }

    List<String> getFormattedHotkeys(List<String> hotkeys) {
        ArrayList<String> formattedList = new ArrayList<>();

        int size = hotkeys.size();
        for(int i = 0; i < size; i++) {
            formattedList.add(getDisplayFormat((hotkeys.get(i))));
        }

        return formattedList;
    }

    String getDisplayFormat(String key) {
        int len = key.length();
        int left = (len-1)/2, right = len/2;
        int dividePos = 0;

        for(; left >= 0 && right < len; left--, right++) {
            if (key.charAt(right) == ' ') {
                dividePos = right;
                break;
            } else if (key.charAt(left) == ' ') {
                dividePos = left;
                break;
            }
        }

        String formattedkey;
        if (dividePos != 0) {
            formattedkey = key.substring(0, dividePos) + "\n" + key.substring(dividePos+1);
        }
        else {
            formattedkey = key;
        }

        return formattedkey;
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
