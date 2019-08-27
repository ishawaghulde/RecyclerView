package com.example.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class FixturesActivity extends AppCompatActivity {
    private SectionsPageAdapter mSectionsPageAdapter;

    private int glassOfWater;
    private double sleepHours;

    private ViewPager mViewPager;
    private TabLayout tabLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixtures);
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        RulesFragment rulesFragment = new RulesFragment();
        FixturesFragment fixturesFragemnt = new FixturesFragment();
        adapter.addFragment(rulesFragment, "RULE BOOK");
        adapter.addFragment(fixturesFragemnt, "FIXTURES");
        viewPager.setAdapter(adapter);

    }
}
