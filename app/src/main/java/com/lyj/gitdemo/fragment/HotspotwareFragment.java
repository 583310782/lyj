package com.lyj.gitdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lyj.gitdemo.R;
import com.lyj.gitdemo.adapter.HotspotwareAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2016/7/27.
 */
public class HotspotwareFragment extends Fragment{
    View view;
    HotspotwareAdapter adapter;
    List<Fragment> list;
    List<String> list1;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_hot_repo, container, false);
        tabLayout= (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager= (ViewPager) view.findViewById(R.id.viewPager);
        list=new ArrayList<Fragment>();
        list1=new ArrayList<String>();
        list1.add("Java");
        list1.add("JavaScript");
        list1.add("Go");
        list1.add("HTML");
        list1.add("CSS");
        list1.add("Objective-C");
        list1.add("Python");
        list1.add("Swift");
        list1.add("Ruby");
        for(int i=0;i<list1.size();i++){
            HotspotFragment hotspotFragment=new HotspotFragment();
            list.add(hotspotFragment);
        }
        adapter=new HotspotwareAdapter(getChildFragmentManager(),list,list1);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}
