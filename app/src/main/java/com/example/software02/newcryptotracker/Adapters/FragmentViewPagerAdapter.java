package com.example.software02.newcryptotracker.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.software02.newcryptotracker.Fragments.GeneralPrices;
import com.example.software02.newcryptotracker.Fragments.PricesFragment;
import com.example.software02.newcryptotracker.Fragments.SpecialPrices;

public class FragmentViewPagerAdapter extends FragmentStatePagerAdapter {

    private static final int TAB_COUNT = 2;

    public FragmentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if(i ==0)
           return new GeneralPrices();
        else
            return new SpecialPrices();
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if(position ==0)
            return "General Prices";
        else
            return "My Prices in Advance";
    }
}
