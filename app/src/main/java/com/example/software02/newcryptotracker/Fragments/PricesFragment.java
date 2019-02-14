package com.example.software02.newcryptotracker.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.software02.newcryptotracker.Adapters.FragmentViewPagerAdapter;
import com.example.software02.newcryptotracker.Interfaces.ItemClickListener;
import com.example.software02.newcryptotracker.R;

public class PricesFragment extends Fragment implements ItemClickListener {
    View root = null;
    private int pageCount =0;
    private String pageTitle ="";


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ViewPager viewPager =(ViewPager) root.findViewById(R.id.fViewPager);
        FragmentViewPagerAdapter fAdapter = new FragmentViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(fAdapter);
        TabLayout ftabs = (TabLayout) root.findViewById(R.id.ftabs);
        ftabs.setupWithViewPager(viewPager);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.prices_fragment_layout, container, false);
        return  root;
    }

    @Override
    public void onClick(View view, int position) {

    }
}
