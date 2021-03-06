package thachpham.hometest.hotkey;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import thachpham.hometest.databinding.ViewholderHotkeyBinding;
import thachpham.hometest.util.TextFormatter;

public class HotkeyAdapter extends RecyclerView.Adapter<HotkeyAdapter.HotkeyViewHolder> {
    int mColor[] =  {0xFF005956, 0xFF906D20, 0xFF006A9D, 0xFFA05819, 0xFF91271A,
                    0xFF8F261A, 0xFF00316F, 0xFF196E33, 0xFF005B57, 0xFFAA6C1F,
                    0xFF946D20, 0xFF590674, 0xFF00718B, 0xFF995116, 0xFF91262E };

    List<String> mHotkeys;

    public HotkeyAdapter(List<String> hotkeys) {
        mHotkeys = getFormattedHotkeys(hotkeys);
    }

    List<String> getFormattedHotkeys(List<String> hotkeys) {
        ArrayList<String> formattedList = new ArrayList<>();

        int size = hotkeys.size();
        for(int i = 0; i < size; i++) {
            formattedList.add(TextFormatter.getTwoLineFormat((hotkeys.get(i))));
        }

        return formattedList;
    }

    @NonNull
    @Override
    public HotkeyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewholderHotkeyBinding itemBinding = ViewholderHotkeyBinding.inflate(inflater, parent, false);

        HotkeyViewHolder holder = new HotkeyViewHolder(itemBinding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HotkeyViewHolder holder, int position) {
        holder.mBinding.tvKey.setText(mHotkeys.get(position));
        holder.mBinding.container.setCardBackgroundColor(mColor[position % mColor.length]);
    }

    @Override
    public int getItemCount() {
        return mHotkeys.size();
    }

    public class HotkeyViewHolder extends RecyclerView.ViewHolder {
        ViewholderHotkeyBinding mBinding;

        public HotkeyViewHolder(@NonNull ViewholderHotkeyBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }
}
