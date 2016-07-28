package com.lyj.gitdemo.view;

import java.util.List;

/**
 * Created by 1 on 2016/7/28.
 */
public interface Hotspotfootview {
    void showLoadMoreLoading();
    void hideLoadMore();
    void showLoadMoreErro(String erroMsg);
    void addMoreData(List<String> datas);
}
