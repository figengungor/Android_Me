package com.example.android.android_me.ui;

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

public class MasterListFragment extends Fragment {

    public MasterListFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master_list, container, false);
        RecyclerView bodyPartImageRv = view.findViewById(R.id.bodyPartImageRv);
        MasterListAdapter adapter = new MasterListAdapter();
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        bodyPartImageRv.setLayoutManager(layoutManager);
        bodyPartImageRv.setAdapter(adapter);
        return view;
    }
}
