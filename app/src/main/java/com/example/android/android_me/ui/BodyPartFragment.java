package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.List;

/**
 * Created by figengungor on 3/26/2018.
 */

public class BodyPartFragment extends Fragment {

    private static final String TAG = BodyPartFragment.class.getSimpleName();
    private List<Integer> imageIds;
    private int listIndex;

    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView bodyPartIv = view.findViewById(R.id.bodyPartIv);
        if (imageIds != null) {
            bodyPartIv.setImageResource(imageIds.get(listIndex));
        } else {
            Log.e(TAG, "Hoyt. You need to set imageIds of this fragment." );
        }

        return view;
    }

    public void setImageIds(List<Integer> imageIds) {
        this.imageIds = imageIds;
    }

    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }
}
