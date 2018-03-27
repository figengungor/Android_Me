package com.example.android.android_me.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnInteractionListener {

    private int headIndex;
    private int bodyIndex;
    private int legIndex;
    private static String HEAD_INDEX = "head_index";
    private static String BODY_INDEX = "body_index";
    private static String LEG_INDEX = "leg_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            headIndex = savedInstanceState.getInt(HEAD_INDEX);
            bodyIndex = savedInstanceState.getInt(BODY_INDEX);
            legIndex = savedInstanceState.getInt(LEG_INDEX);
        }
    }

    @Override
    public void onImageSelected(int position) {
        //There are 12 images for each part
        //0 => head fragment 1 => body fragment, 2 => leg fragment
        int bodyPartNumber = position / 12;
        int bodyPartListIndex = position - 12 * bodyPartNumber;

        switch (bodyPartNumber) {
            case 0:
                headIndex = bodyPartListIndex;
                break;
            case 1:
                bodyIndex = bodyPartListIndex;
                break;
            case 2:
                legIndex = bodyPartListIndex;
                break;
            default:
                break;
        }
    }

    @Override
    public void onNextButtonClicked() {
        Bundle bundle = new Bundle();
        bundle.putInt(AndroidMeActivity.EXTRA_HEAD_INDEX, headIndex);
        bundle.putInt(AndroidMeActivity.EXTRA_BODY_INDEX, bodyIndex);
        bundle.putInt(AndroidMeActivity.EXTRA_LEG_INDEX, legIndex);

        Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(HEAD_INDEX, headIndex);
        outState.putInt(BODY_INDEX, bodyIndex);
        outState.putInt(LEG_INDEX, legIndex);
    }


}
