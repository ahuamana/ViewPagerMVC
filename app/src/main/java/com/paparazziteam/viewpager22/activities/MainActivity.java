package com.paparazziteam.viewpager22.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.paparazziteam.viewpager22.R;
import com.paparazziteam.viewpager22.adapter.ViewPageAdapter;
import com.paparazziteam.viewpager22.fragments.ChatsFragment;
import com.paparazziteam.viewpager22.fragments.PhotosFragment;
import com.paparazziteam.viewpager22.fragments.StatusFragment;

public class MainActivity extends AppCompatActivity {

    TabLayout mTabLayout;
    ViewPager2 mViewPager;

    ChatsFragment mChatsFragment;
    PhotosFragment mPhotosFragment;
    StatusFragment mStatusFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);

        mChatsFragment = new ChatsFragment();
        mPhotosFragment = new PhotosFragment();
        mStatusFragment = new StatusFragment();

        mViewPager.setOffscreenPageLimit(3);

        ViewPageAdapter adapter = new ViewPageAdapter(this);

        adapter.add(mChatsFragment, "Chats");
        adapter.add(mPhotosFragment, "Photos");
        adapter.add(mStatusFragment, "Status");

        mViewPager.setAdapter(adapter);

        mViewPager.setCurrentItem(3);

        new TabLayoutMediator(mTabLayout, mViewPager, adapter.configurationTitle()).attach();



    }
}