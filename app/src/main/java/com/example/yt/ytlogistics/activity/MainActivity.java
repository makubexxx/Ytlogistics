package com.example.yt.ytlogistics.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.yt.ytlogistics.R;
import com.example.yt.ytlogistics.adapter.ContentPagerAdapter;
import com.example.yt.ytlogistics.entity.TabItemModel;
import com.example.yt.ytlogistics.fragment.CarlineFragment;
import com.example.yt.ytlogistics.view.MyCustomViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // 第三方 tablayout+viewpager
    private TabLayout mTabLayout;
    private MyCustomViewPager mTabViewPager;

    private List<TabItemModel> tabIndicators;
    private List<Fragment> tabFragments;

    private ContentPagerAdapter contentAdapter;

    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initViews();
        initDatas();
        initEvents();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void initViews() {
        mTabLayout = (TabLayout) findViewById(R.id.tl_top);
        mTabViewPager = (MyCustomViewPager) findViewById(R.id.vp_tab);
        mTabViewPager.setOffscreenPageLimit(3);//禁止预加载【如果想要延迟首个选项卡的销毁时间，那么就需要设置这个数值高点】
    }

    private void initDatas() {
        //初始化选项卡子项的文本、超链接model集合
        tabIndicators = new ArrayList<TabItemModel>();
        tabIndicators.add(new TabItemModel("百度","http://www.baidu.com"));
        tabIndicators.add(new TabItemModel("CSDN","http://blog.csdn.net"));
        tabIndicators.add(new TabItemModel("博客园","http://www.cnblogs.com"));
        tabIndicators.add(new TabItemModel("极客头条","http://geek.csdn.net/mobile"));
        tabIndicators.add(new TabItemModel("优设","http://www.uisdc.com/"));
        tabIndicators.add(new TabItemModel("玩Android","http://www.wanandroid.com/index"));
        tabIndicators.add(new TabItemModel("掘金","https://juejin.im/"));

        //初始化碎片集合
        tabFragments = new ArrayList<>();

        for(int i=0;i<tabIndicators.size();i++){
            TabItemModel tabItemModel = tabIndicators.get(i);

            Bundle bundle = new Bundle();
            bundle.putString("param", tabItemModel.getTabUrl());
            tabFragments.add(CarlineFragment.getInstance(CarlineFragment.class,bundle));
        }
        //实例化Adapter
        contentAdapter = new ContentPagerAdapter(getSupportFragmentManager(),tabIndicators,tabFragments);
        mTabViewPager.setAdapter(contentAdapter);
        //TabLayout和ViewPager相关联
        mTabLayout.setupWithViewPager(mTabViewPager);
    }

    private void initEvents() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中了tab的逻辑
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未选中了tab的逻辑
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //再次选中了tab的逻辑
            }
        });
    }
}