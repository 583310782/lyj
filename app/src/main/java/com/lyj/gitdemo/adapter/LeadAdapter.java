package com.lyj.gitdemo.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.lyj.gitdemo.view.LeadView1;
import com.lyj.gitdemo.view.LeadView2;
import com.lyj.gitdemo.view.LeadView3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2016/7/26.
 */
public class LeadAdapter extends PagerAdapter{
    private List<View> list=new ArrayList<View>();

    public LeadAdapter(Context context){
        list.add(new LeadView1(context));
        list.add(new LeadView2(context));
        list.add(new LeadView3(context));
    }
    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = list.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = list.get(position);
        container.removeView(view);

    }
}
