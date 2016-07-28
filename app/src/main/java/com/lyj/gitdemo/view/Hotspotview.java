package com.lyj.gitdemo.view;

import android.view.View;

import java.util.List;

/**
 * Created by 1 on 2016/7/28.
 */
public interface Hotspotview {
    void showview();
    void  blankview();
    void errorview();
    void showMessage(String msg);
    void stopRefresh();
    void refreshData(List<String> data);
}
