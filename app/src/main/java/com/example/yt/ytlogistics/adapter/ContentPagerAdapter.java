package com.example.yt.ytlogistics.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.yt.ytlogistics.entity.TabItemModel;

import java.util.List;

/**
 * Created by chebole on 2018/7/25.
 */

public class ContentPagerAdapter extends FragmentStatePagerAdapter {

    private List<TabItemModel> tabIndicators;
    /**碎片集合*/
    private List<Fragment> fragmentList;

    public ContentPagerAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    /**
     * 自定义构造函数：用于传递碎片集合过来
     * 一般都写上*/
    public ContentPagerAdapter(FragmentManager fm, List<TabItemModel> tabIndicators, List<Fragment> fragmentList) {
        super(fm);
        this.tabIndicators = tabIndicators;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabIndicators.get(position).getTabTitle();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //viewpager+fragment来回滑动fragment重新加载的简单解决办法：注释下面的代码
        //不建议使用，因为当选项卡过多的时候，如果不销毁的是，担心内存溢出
        //http://blog.csdn.net/qq_28058443/article/details/51519663
        super.destroyItem(container, position, object);
    }
}
