package com.example.yt.ytlogistics.entity;

/**
 * Created by chebole on 2018/7/25.
 */

public class TabItemModel {
    private String tabTitle;
    private String tabUrl;

    public TabItemModel(String tabTitle, String tabUrl){
        this.tabTitle = tabTitle;
        this.tabUrl = tabUrl;
    }

    public String getTabTitle() {
        return tabTitle;
    }

    public void setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    public String getTabUrl() {
        return tabUrl;
    }

    public void setTabUrl(String tabUrl) {
        this.tabUrl = tabUrl;
    }
}
