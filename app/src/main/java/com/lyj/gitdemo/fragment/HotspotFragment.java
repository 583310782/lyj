package com.lyj.gitdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.lyj.gitdemo.R;
import com.lyj.gitdemo.parser.Data;
import com.lyj.gitdemo.view.FootView;
import com.lyj.gitdemo.view.Hotspotlistview;
import com.lyj.gitdemo.view.Hotspotview;
import com.mugen.Mugen;
import com.mugen.MugenCallbacks;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.header.StoreHouseHeader;

/**
 * Created by 1 on 2016/7/27.
 */
public class HotspotFragment extends Fragment implements Hotspotlistview{
    private ListView listView;
    private PtrClassicFrameLayout ptrClassicFrameLayout;
    View view;
    String str;
    private TextView emptyView,errorView;
    private Data data;
    private FootView footView;
    private ArrayAdapter<String> adapter;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_repo_list,container,false);
        listView= (ListView) view.findViewById(R.id.lvRepos);
        ptrClassicFrameLayout= (PtrClassicFrameLayout) view.findViewById(R.id.ptrClassicFrameLayout);
        emptyView= (TextView) view.findViewById(R.id.emptyView);
        errorView= (TextView) view.findViewById(R.id.errorView);
        data=new Data(this);
        adapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                new ArrayList<String>()
        );
        listView.setAdapter(adapter);
        pulldown();
        initLoadMoreScroll();
        return view;
    }

    private void initLoadMoreScroll() {
        footView=new FootView(getContext());
        Mugen.with(listView, new MugenCallbacks() {
            @Override
            public void onLoadMore() {
                //执行加载方法
                data.loadMore();
            }

            @Override
            public boolean isLoading() {
                return listView.getFooterViewsCount()>0&&footView.isLoading();
            }

            @Override
            public boolean hasLoadedAllItems() {
                return listView.getFooterViewsCount()>0&&footView.isComplete();
            }
        }).start();
    }

    public void pulldown(){
        ptrClassicFrameLayout.setLastUpdateTimeRelateObject(this);
        ptrClassicFrameLayout.setDurationToCloseHeader(1500);
        ptrClassicFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                data.refresg();
                //写获取数据方法
            }
        });
        StoreHouseHeader header = new StoreHouseHeader(getContext());
        header.initWithString("I LIKE " + getStr());
        header.setPadding(0, 60, 0, 60);
        ptrClassicFrameLayout.setHeaderView(header);
        ptrClassicFrameLayout.addPtrUIHandler(header);
        ptrClassicFrameLayout.setBackgroundResource(R.color.colorRefresh);
    }
    //显示视图z
    @Override
    public void showview(){
        ptrClassicFrameLayout.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
    }
    //空白视图
    @Override
    public void  blankview(){
        ptrClassicFrameLayout.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
    }
    //错误视图
    @Override
    public void errorview(){
        ptrClassicFrameLayout.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
    }


    @Override
    public void showMessage(String msg) {
        //写Toast
    }
    //停止刷新
    @Override
    public void stopRefresh() {
        ptrClassicFrameLayout.refreshComplete();
    }
    //刷新数据
    @Override
    public void refreshData(List<String> data) {
        adapter.clear();
        adapter.addAll(data);
        adapter.notifyDataSetChanged();
    }

    //上拉
    @Override
    public void showLoadMoreLoading() {
        if(listView.getFooterViewsCount()==0){
            listView.addFooterView(footView);
        }
        footView.showLoading();
    }

    @Override
    public void hideLoadMore() {
        listView.removeFooterView(footView);
    }

    @Override
    public void showLoadMoreErro(String erroMsg) {
        if(listView.getFooterViewsCount()==0){
            listView.addFooterView(footView);
        }
        footView.showError(erroMsg);
    }

    @Override
    public void addMoreData(List<String> datas) {
        adapter.addAll(datas);
        adapter.notifyDataSetChanged();
    }
}
