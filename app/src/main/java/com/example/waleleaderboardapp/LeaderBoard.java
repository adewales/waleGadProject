package com.example.waleleaderboardapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class LeaderBoard extends AppCompatActivity {


        Button btnSubmit;
        TabLayout tabLayout;
        private ViewPager viewPager;
        //PagerAdapter mPagerAdapter;

        TabItem tabLearner;
        TabItem tabSkill;

        //private FragmentCollectionAdapter adapter;

        private ViewPagerAdapter mViewPagerAdapter;


        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_leader_board);

            btnSubmit = findViewById(R.id.btnSubmit);
            btnSubmit.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LeaderBoard.this, Submission.class);
                    startActivity(intent);


                }

            });

            //viewPager = findViewById(R.id.viewpager);
            //adapter = new FragmentCollectionAdapter(getSupportFragmentManager());

            //viewPager.setAdapter(adapter);

       /* viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tab_layout);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Learner");
        arrayList.add("Skill IQ");


        prepareViewPager(viewPager, arrayList);

        tabLayout.setupWithViewPager(viewPager);

        */

            //mToolbar.setTitle(getResources().getString(R.string.app_name));
            getSupportActionBar();

            tabLayout = findViewById(R.id.tabLayout);
            tabLearner = findViewById(R.id.tabLearner);
            tabSkill = findViewById(R.id.tabSkill);

            viewPager =findViewById(R.id.viewPager);
            mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 2);

            viewPager.setAdapter(mViewPagerAdapter);

            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                    if (tab.getPosition() == 0) {
                        tabLayout.setBackgroundColor(ContextCompat.getColor(LeaderBoard.this, R.color.colorMainConstraint));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            getWindow().setStatusBarColor(ContextCompat.getColor(LeaderBoard.this, R.color.colorPrimaryDark));

                        }
                    } else if (tab.getPosition() == 1) {
                        tabLayout.setBackgroundColor(ContextCompat.getColor(LeaderBoard.this, R.color.colorPrimary));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            getWindow().setStatusBarColor(ContextCompat.getColor(LeaderBoard.this, R.color.colorPrimaryDark));

                        }
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });

            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



        }


    }