package com.lyj.gitdemo.fragment;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.lyj.gitdemo.R;
import com.lyj.gitdemo.adapter.LeadAdapter;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by 1 on 2016/7/26.
 */
public class LeadFragment extends Fragment{
    private ViewPager vp;
    LeadAdapter adapter;
    CircleIndicator circleIndicator;
    private FrameLayout layoutPhone;
    private ImageView ivPhoneFont;
    private FrameLayout content;
    int color1;
    int color2;
    int color3;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_splash_pager,container,false);
        vp= (ViewPager) view.findViewById(R.id.viewPager);
        circleIndicator= (CircleIndicator) view.findViewById(R.id.indicator);
        layoutPhone= (FrameLayout) view.findViewById(R.id.layoutPhone);
        ivPhoneFont= (ImageView) view.findViewById(R.id.ivPhoneFont);
        content= (FrameLayout) view.findViewById(R.id.content);
        color1=getResources().getColor(R.color.colorBlue);
        color2=getResources().getColor(R.color.colorGreen);
        color3=getResources().getColor(R.color.colorRed);
        adapter=new LeadAdapter(getActivity());
        vp.setAdapter(adapter);
        circleIndicator.setViewPager(vp);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                ArgbEvaluator argbEvaluator=new ArgbEvaluator();
                if (position == 0) {
                    int i= (int) argbEvaluator.evaluate(positionOffset,color1,color2);
                    content.setBackgroundColor(i);
                    ivPhoneFont.setAlpha(positionOffset);
                    float f=0.2f+positionOffset*0.8f;
                    layoutPhone.setScaleX(f);
                    layoutPhone.setScaleY(f);
//                    int j= (int) ((positionOffset-1)*300);
//                    layoutPhone.setTranslationX(j);
                    int o= (int) (0.2+positionOffset*0.3);
                    layoutPhone.setPivotX(o);
                }
                if (position == 1) {
                    int i= (int) argbEvaluator.evaluate(positionOffset,color2,color3);
                    content.setBackgroundColor(i);
                    layoutPhone.setTranslationX(-positionOffsetPixels);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }
}
