package com.lyj.gitdemo.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.lyj.gitdemo.R;

/**
 * Created by 1 on 2016/7/26.
 */
public class LeadView1 extends FrameLayout{
    public LeadView1(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.content_pager_0,this,true);
    }
}
