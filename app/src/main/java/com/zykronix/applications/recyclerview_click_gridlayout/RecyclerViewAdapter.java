package com.zykronix.applications.recyclerview_click_gridlayout;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zykronix.applications.recyclerview_click_gridlayout.databinding.CardLayoutBinding;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<RecyclerData> courseDataArrayList;
    private Context mcontext;
    RecyclerViewAdapter.OnItemClick onItemClick;

    int selected = -1;

    public RecyclerViewAdapter(ArrayList<RecyclerData> recyclerDataArrayList, Context mcontext) {
        this.courseDataArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // Set the data to textview and imageview.
        RecyclerData recyclerData = courseDataArrayList.get(position);
        ((ViewHolder) holder).binding.idTVCourse.setText(recyclerData.getTitle());
        ((ViewHolder) holder).binding.idIVcourseIV.setImageResource(recyclerData.getImgid());

        if (selected == position) {
            holder.itemView.findViewById(R.id.each_item).setBackgroundColor(0xFF7B7B7B);
            ((ViewHolder) holder).binding.idTVCourse.setTextColor(Color.WHITE);
        } else {
            holder.itemView.findViewById(R.id.each_item).setBackgroundColor(Color.TRANSPARENT);
            ((ViewHolder) holder).binding.idTVCourse.setTextColor(Color.BLACK);
        }

        holder.itemView.setOnClickListener(v -> {
            onItemClick.onItemClick(recyclerData, position);
        });
    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return courseDataArrayList.size();
    }

    public RecyclerViewAdapter.OnItemClick getOnItemClick() {
        return onItemClick;
    }

    interface OnItemClick{
        void onItemClick(RecyclerData itemModel, int position);
    }

    public void setSelected(int position) {
        this.selected = position;
    }

    // View Holder Class to handle Recycler View.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardLayoutBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CardLayoutBinding.bind(itemView);
        }

    }
}
