package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.android_me.R;

/**
 * Created by figengungor on 3/27/2018.
 */

public class MasterListFragment extends Fragment implements MasterListAdapter.OnItemClickListener {

    OnImageClickListener callback;

    public interface OnImageClickListener {
        void onImageSelected(int position);
    }

    public MasterListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master_list, container, false);
        RecyclerView bodyPartImageRv = view.findViewById(R.id.bodyPartImageRv);
        MasterListAdapter adapter = new MasterListAdapter();
        adapter.setOnItemClickListener(this);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        bodyPartImageRv.setLayoutManager(layoutManager);
        bodyPartImageRv.setAdapter(adapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            callback = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + "must implement OnImageClickListener");
        }
    }

    @Override
    public void onItemClicked(int position) {
        callback.onImageSelected(position);
    }
}
