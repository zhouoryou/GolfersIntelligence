package com.qiu.golfersintelligence.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qiu.golfersintelligence.R;
import com.qiu.golfersintelligence.adapter.vp.MatchTabPageAdapter;
import com.qiu.golfersintelligence.base.BaseActivity;
import com.qiu.golfersintelligence.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by a on 2017/9/18.
 * 赛事
 */

public class MatchFragment extends BaseFragment{

    private MatchTabPageAdapter matchTabPageAdapter;
    private List<String> tabList=new ArrayList<String>();
    private Context mContext;

    @BindView(R.id.tablayout)
    public TabLayout tabLayout;
    @BindView(R.id.viewpager)
    public ViewPager viewPager;

    @Override
    public int bindLayout() {
        return R.layout.match_fragment;
    }


    public void setTabData(){
        tabList.clear();
        tabList.add("未开始");
        tabList.add("已结束");
        tabList.add("我的订阅");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext=activity;
    }

    @Override
    public void initView(View view) {
        ButterKnife.bind(this,view);

        matchTabPageAdapter=new MatchTabPageAdapter(getChildFragmentManager());
        viewPager.setAdapter(matchTabPageAdapter);
        tabLayout.setupWithViewPager(viewPager);

        setTabData();
        initTabLayout();


    }

    public void initTabLayout(){
        for (int i=0;i<tabList.size();i++){
            TabLayout.Tab tab=tabLayout.getTabAt(i);
            tab.setCustomView(R.layout.match_tab_item);
            TextView intelligence_tab_text=tab.getCustomView().findViewById(R.id.match_tab_text);
            intelligence_tab_text.setText(tabList.get(i));
            switch (i){
                case 0:
                    intelligence_tab_text.setTextColor(Color.parseColor("#F9C134"));
                    break;
                case  1:
                    intelligence_tab_text.setTextColor(Color.parseColor("#9D9D9D"));
                    break;
                default:
                    intelligence_tab_text.setTextColor(Color.parseColor("#9D9D9D"));
                    break;
            }
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                TextView intelligence_tab_text=tab.getCustomView().findViewById(R.id.match_tab_text);
                intelligence_tab_text.setTextColor(Color.parseColor("#F9C134"));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                TextView intelligence_tab_text=tab.getCustomView().findViewById(R.id.match_tab_text);
                intelligence_tab_text.setTextColor(Color.parseColor("#9D9D9D"));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
