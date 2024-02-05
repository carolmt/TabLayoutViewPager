package com.example.tablayoutviewpager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tablayoutviewpager.fragment.Tab1;
import com.example.tablayoutviewpager.fragment.Tab3;
import com.example.tablayoutviewpager.fragment.nav_gallery;

public class SectionsPagerAdapter extends FragmentStateAdapter {

    public SectionsPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                Fragment fragment1 = new Tab1();
                Bundle args1 = new Bundle();
                args1.putString("text", "fragment1");
                fragment1.setArguments(args1);
                return fragment1;
            case 1:
                Fragment fragment2 = new nav_gallery();
                Bundle args2 = new Bundle();
                args2.putString("text", "fragment2");
                fragment2.setArguments(args2);
                return fragment2;
            case 2:
                Fragment fragment3 = new Tab3();
                Bundle args3 = new Bundle();
                args3.putString("text", "fragment3");
                fragment3.setArguments(args3);
                return fragment3;
            default:
                throw new IllegalStateException("Invalid position " + position);
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Número de tabs
    }
}