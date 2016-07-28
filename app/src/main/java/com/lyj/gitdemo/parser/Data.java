package com.lyj.gitdemo.parser;

import android.os.AsyncTask;

import com.lyj.gitdemo.view.Hotspotlistview;
import com.lyj.gitdemo.view.Hotspotview;

import java.util.ArrayList;

/**
 * Created by 1 on 2016/7/28.
 */
public class Data {
    private Hotspotlistview hotspotview;
    private int count;

    public Data(Hotspotlistview hotspotview) {
        this.hotspotview = hotspotview;
    }
    //上拉加载更多
    public void loadMore() {
        hotspotview.showLoadMoreLoading();
        new LoadMoreTask().execute();
    }
    //下拉刷新
    public void refresg(){
        new RefreshTask().execute();
    }
    final class RefreshTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ArrayList<String> datas = new ArrayList<String>();
            for (int i = 0; i < 20; i++) {
                datas.add("测试数据 " + (count++));
            }
            hotspotview.stopRefresh();
            hotspotview.refreshData(datas);
            hotspotview.showview();
        }
    }
    final class LoadMoreTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ArrayList<String> datas = new ArrayList<String>();
            for (int i = 0; i < 20; i++) {
                datas.add("测试数据 " + (count++));
            }
            hotspotview.addMoreData(datas);
            hotspotview.hideLoadMore();
        }
    }
}
