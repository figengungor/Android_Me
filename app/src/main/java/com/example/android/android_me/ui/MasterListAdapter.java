package com.example.android.android_me.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

/**
 * Created by figengungor on 3/27/2018.
 */

public class MasterListAdapter extends RecyclerView.Adapter<MasterListAdapter.MasterListViewHolder> {

    List<Integer> imageIds = AndroidImageAssets.getAll();

    @NonNull
    @Override
    public MasterListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MasterListViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_master_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MasterListViewHolder holder, int position) {
        holder.bodyPartIv.setImageResource(imageIds.get(position));
    }

    @Override
    public int getItemCount() {
        return imageIds.size();
    }

    class MasterListViewHolder extends RecyclerView.ViewHolder {
        ImageView bodyPartIv;

        public MasterListViewHolder(View itemView) {
            super(itemView);
            bodyPartIv = itemView.findViewById(R.id.bodyPartIv);
        }
    }
}
