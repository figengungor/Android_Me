/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    public final static String EXTRA_HEAD_INDEX = "head_index";
    public final static String EXTRA_BODY_INDEX = "body_index";
    public final static String EXTRA_LEG_INDEX = "leg_index";

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        Bundle bundle = getIntent().getExtras();
        headIndex = bundle.getInt(EXTRA_HEAD_INDEX);
        bodyIndex = bundle.getInt(EXTRA_BODY_INDEX);
        legIndex = bundle.getInt(EXTRA_LEG_INDEX);

        if (savedInstanceState == null) {

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
    }
}
