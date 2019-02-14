package com.example.software02.newcryptotracker;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.software02.newcryptotracker.Fragments.MainFragment;
import com.example.software02.newcryptotracker.Fragments.PricesFragment;
import com.example.software02.newcryptotracker.Interfaces.ItemClickListener;

public class MainActivity extends AppCompatActivity  {

    BottomNavigationView bottomNavigation = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setExitTransition(new Explode());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Find Components Section*/
        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_nav);

        /*Fragment Manager Inıtialization*/
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment pricesFragment = new PricesFragment();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.content);
        fragmentTransaction.add(R.id.content, pricesFragment).commit();

        /*Set On Listener Section like Click Listener*/
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_edit:
                        Toast.makeText(getBaseContext(),"Hell Yeah", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_add:
                         Fragment pricesFragment = new PricesFragment();
                         Fragment currentFragment = fragmentManager.findFragmentById(R.id.content);
                         if(currentFragment == null){
                             fragmentTransaction.replace(R.id.content, pricesFragment).commit();
                         }
                         else{
                              String myTag = pricesFragment.getClass().toString();
                              if(!pricesFragment.getClass().toString().equals(currentFragment.getClass().toString())){
                                  fragmentTransaction.replace(R.id.content, pricesFragment).commit();
                               }
                         }
                    case R.id.action_delete:
                        return true;
                }
                return true;
            }
        });
    }
}
