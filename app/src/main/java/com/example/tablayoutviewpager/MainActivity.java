package com.example.tablayoutviewpager;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tablayoutviewpager.fragment.Tab1;
import com.example.tablayoutviewpager.fragment.Tab3;
import com.example.tablayoutviewpager.fragment.nav_gallery;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setTabTextColors(Color.GRAY, Color.WHITE); // Set tab text color to white
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER); // Center the tabs
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE); // Set tab mode to scrollable

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Tab1");
                            break;
                        case 1:
                            tab.setText("Tab2");
                            break;
                        case 2:
                            tab.setText("Tab3");
                            break;
                    }
                }).attach();
    }

    private void setupViewPager(ViewPager2 viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        adapter.addFragment(new Tab1(), "Tab1");
        adapter.addFragment(new nav_gallery(), "Tab2");
        adapter.addFragment(new Tab3(), "Tab3");
        viewPager.setAdapter(adapter);
    }
}