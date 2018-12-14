package com.jae57.me.develop;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, View.OnClickListener {

    ViewPager viewPager;
    FloatingActionButton fab;
    CoordinatorLayout coordinatorLayout;

    boolean isOK = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinator);

        viewPager=(ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(this);

        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> fragments=new ArrayList<>();
        String title[]=new String[]{"지도", "채팅방 목록","내 채팅방 목록"};
        public MyPagerAdapter(FragmentManager fm){
            super(fm);
           /* fragments.add(new MapFragment());
            fragments.add(new AllChatFragment());
            fragments.add(new MyChatFragment());*/
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }

    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    public void onTabUnselected(TabLayout.Tab tab) {    }
    public void onTabReselected(TabLayout.Tab tab) {    }
    public void onClick(View v){
        if(v==fab){
            isOK = false;
            Snackbar.make(coordinatorLayout, "채팅방을 추가할까요?", Snackbar.LENGTH_LONG)
                    .setAction("네!!", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            isOK = true;
                        }
                    }).show();
            if(isOK == true){
                Intent intent = new Intent(this, CreateRoomActivity.class);
                startActivityForResult(intent, 20);
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 20 && resultCode == RESULT_OK){
            Toast toast = Toast.makeText(this, "나눔방 생성 완료", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}