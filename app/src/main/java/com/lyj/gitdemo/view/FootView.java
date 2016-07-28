package com.lyj.gitdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lyj.gitdemo.R;

/**
 * Created by 1 on 2016/7/28.
 */
public class FootView extends FrameLayout{
    private ProgressBar progressBar;
    private TextView tv_complete,tv_error;
    private static final int STATE_LOADING = 0;
    private static final int STATE_COMPLETE = 1;
    private static final int STATE_ERROR = 2;
    private int i = STATE_LOADING;
    public FootView(Context context) {
        this(context, null);
    }

    public FootView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FootView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(getContext()).inflate(R.layout.content_load_footer, this, true);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        tv_complete= (TextView) findViewById(R.id.tv_complete);
        tv_error= (TextView) findViewById(R.id.tv_error);
    }
    //是否加载中
    public boolean isLoading(){
        return i==STATE_LOADING;
    }
    //是否加载完成
    public boolean isComplete(){
        return i==STATE_COMPLETE;
    }
    //显示加载中
    public void showLoading(){
        i=STATE_LOADING;
        progressBar.setVisibility(View.VISIBLE);
        tv_complete.setVisibility(View.GONE);
        tv_error.setVisibility(View.GONE);
    }
    //显示加载完成
    public void showComplete(){
        i=STATE_COMPLETE;
        progressBar.setVisibility(View.GONE);
        tv_complete.setVisibility(View.VISIBLE);
        tv_error.setVisibility(View.GONE);
    }
    //显示没有数据了
    public void showError(String strerr){
        i=STATE_ERROR;
        progressBar.setVisibility(View.GONE);
        tv_complete.setVisibility(View.GONE);
        tv_error.setVisibility(View.VISIBLE);
    }
    public void setErrorClickListener(OnClickListener onClickListener){
        tv_error.setOnClickListener(onClickListener);
    }
}
