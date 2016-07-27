package com.lyj.gitdemo.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2016/7/17.
 */
public abstract class MybaseAdapter<Type> extends BaseAdapter{
    public LayoutInflater inflater;
    public Context context;
    public ArrayList<Type> list=new ArrayList<Type>();

    public MybaseAdapter(Context context) {
        this.context = context;
        this.inflater= LayoutInflater.from(context);
    }
    public void add(List<Type> e){
        if(e!=null){
            list.addAll(e);
        }
    }public void addnew(List<Type> e){
            list.clear();
            list.addAll(e);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return setView(position,convertView,parent);
    }
    public abstract View setView(int position, View convertView, ViewGroup parent);
}
