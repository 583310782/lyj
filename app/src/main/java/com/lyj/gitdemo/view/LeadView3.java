package com.lyj.gitdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.lyj.gitdemo.R;

/**
 * Created by 1 on 2016/7/26.
 */
public class LeadView3 extends FrameLayout{
    private ImageView ivBubble1,ivBubble2,ivBubble3;
    public LeadView3(Context context) {
        this(context,null);
    }
    public LeadView3(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LeadView3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(getContext()).inflate(R.layout.content_pager_2, this, true);
        ivBubble1= (ImageView) findViewById(R.id.ivBubble1);
        ivBubble2= (ImageView) findViewById(R.id.ivBubble2);
        ivBubble3= (ImageView) findViewById(R.id.ivBubble3);
        ivBubble1.setVisibility(View.GONE);
        ivBubble2.setVisibility(View.GONE);
        ivBubble3.setVisibility(View.GONE);
    }
    public void showitem(){
        if(ivBubble1.getVisibility() != View.VISIBLE){
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    ivBubble1.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeInLeft).duration(300).playOn(ivBubble1);
                }
            }, 50);
            postDelayed(new Runnable() {
                @Override public void run() {
                    ivBubble2.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeInLeft).duration(300).playOn(ivBubble2);
                }
            }, 550);
            postDelayed(new Runnable() {
                @Override public void run() {
                    ivBubble3.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeInLeft).duration(300).playOn(ivBubble3);
                }
            }, 1050);
        }
    }




}
