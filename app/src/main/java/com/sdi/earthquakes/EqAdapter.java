package com.sdi.earthquakes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.sdi.earthquakes.databinding.EqItemBinding;

public class EqAdapter extends ListAdapter<Earthquake, EqAdapter.EqViewHolder> {

    public static final DiffUtil.ItemCallback<Earthquake> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Earthquake>() {
                @Override
                public boolean areItemsTheSame(@NonNull Earthquake oldItem, @NonNull Earthquake newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull Earthquake oldItem, @NonNull Earthquake newItem) {
                    return oldItem.equals(newItem);
                }
            };
    protected EqAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public EqAdapter.EqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EqItemBinding binding = EqItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return  new EqViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EqAdapter.EqViewHolder holder, int position) {
        Earthquake earthquake = getItem(position);
        holder.bind(earthquake);
    }

    private OnItemClickListener onItemClickListener;
    interface OnItemClickListener {
        void onItemClick(Earthquake earthquake);
    }
    public void setOnItemClickListener(OnItemClickListener
                                               onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class EqViewHolder extends RecyclerView.ViewHolder {

        private final EqItemBinding binding;
        public EqViewHolder(@NonNull EqItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Earthquake earthquake) {
            binding.txtPlace.setText(earthquake.getPlace());
            binding.txtMagnitud.setText(String.valueOf(earthquake.getMagnitud()));
            binding.txtTime.setText(String.valueOf(earthquake.getTime()));
        }
    }
}
