package com.example.android.android_me.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnInteractionListener {

    private int headIndex;
    private int bodyIndex;
    private int legIndex;
    private static String HEAD_INDEX = "head_index";
    private static String BODY_INDEX = "body_index";
    private static String LEG_INDEX = "leg_index";

    private boolean twoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //https://developer.android.com/training/basics/fragments/communicating.html
        if (findViewById(R.id.bodyPartLl) != null) {
            twoPane = true;
            MasterListFragment masterListFragment = (MasterListFragment) getSupportFragmentManager().findFragmentById(R.id.masterListFragment);
            masterListFragment.setColumns(2);
            masterListFragment.hideNextBtn();
            if (savedInstanceState == null)
                createBodyPartFragments();
        } else {
            twoPane = false;
        }

        if (savedInstanceState != null) {
            headIndex = savedInstanceState.getInt(HEAD_INDEX);
            bodyIndex = savedInstanceState.getInt(BODY_INDEX);
            legIndex = savedInstanceState.getInt(LEG_INDEX);
        }
    }

    private void createBodyPartFragments() {
        BodyPartFragment headFragment = new BodyPartFragment();
        headFragment.setImageIds(AndroidImageAssets.getHeads());
        headFragment.setListIndex(headIndex);

        BodyPartFragment bodyFragment = new BodyPartFragment();
        bodyFragment.setImageIds(AndroidImageAssets.getBodies());
        bodyFragment.setListIndex(bodyIndex);

        BodyPartFragment legFragment = new BodyPartFragment();
        legFragment.setImageIds(AndroidImageAssets.getLegs());
        legFragment.setListIndex(legIndex);

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.headContainerFl, headFragment)
                .commit();

        fragmentManager.beginTransaction()
                .add(R.id.bodyContainerFl, bodyFragment)
                .commit();

        fragmentManager.beginTransaction()
                .add(R.id.legContainerFl, legFragment)
                .commit();
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

        if (twoPane) {
            BodyPartFragment newFragment = new BodyPartFragment();

            switch (bodyPartNumber) {
                case 0:
                    newFragment.setImageIds(AndroidImageAssets.getHeads());
                    newFragment.setListIndex(bodyPartListIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.headContainerFl, newFragment)
                            .commit();
                    break;
                case 1:
                    newFragment.setImageIds(AndroidImageAssets.getBodies());
                    newFragment.setListIndex(bodyPartListIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.bodyContainerFl, newFragment)
                            .commit();
                    break;
                case 2:
                    newFragment.setImageIds(AndroidImageAssets.getLegs());
                    newFragment.setListIndex(bodyPartListIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.legContainerFl, newFragment)
                            .commit();
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(HEAD_INDEX, headIndex);
        outState.putInt(BODY_INDEX, bodyIndex);
        outState.putInt(LEG_INDEX, legIndex);
    }

    @Override
    public void onNextBtnClicked() {
        Bundle bundle = new Bundle();
        bundle.putInt(AndroidMeActivity.EXTRA_HEAD_INDEX, headIndex);
        bundle.putInt(AndroidMeActivity.EXTRA_BODY_INDEX, bodyIndex);
        bundle.putInt(AndroidMeActivity.EXTRA_LEG_INDEX, legIndex);

        Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
