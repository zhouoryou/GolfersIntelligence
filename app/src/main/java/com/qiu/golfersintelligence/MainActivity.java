package com.qiu.golfersintelligence;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;

import com.qiu.golfersintelligence.base.BaseActivity;
import com.qiu.golfersintelligence.view.fragment.MatchFragment;
import com.qiu.golfersintelligence.view.fragment.MineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends BaseActivity {

    //当前选中的tab
    public int selectIndex=0;
    public static final int Match = 0;
    private SupportFragment[] mFragments = new SupportFragment[1];

    @BindView(R.id.iv_intelligence)
    public ImageView iv_intelligence;
    @BindView(R.id.tv_intelligence)
    public TextView tv_intelligence;
    @BindView(R.id.iv_match)
    public ImageView iv_match;
    @BindView(R.id.tv_match)
    public TextView tv_match;
    @BindView(R.id.iv_mine)
    public ImageView iv_mine;
    @BindView(R.id.tv_mine)
    public TextView tv_mine;

    public void setSelectTabStyle(){
        switch (selectIndex){
            case 0:
                iv_intelligence.setImageResource(R.mipmap.home_tab_intelligence_checked);
                tv_intelligence.setTextColor(Color.parseColor("#f9c134"));
                iv_match.setImageResource(R.mipmap.home_tab_match_check);
                tv_match.setTextColor(Color.parseColor("#9D9D9D"));
                iv_mine.setImageResource(R.mipmap.home_tab_mine_check);
                tv_mine.setTextColor(Color.parseColor("#9D9D9D"));
                break;
            case 1:
                iv_intelligence.setImageResource(R.mipmap.home_tab_intelligence_check);
                tv_intelligence.setTextColor(Color.parseColor("#9D9D9D"));
                iv_match.setImageResource(R.mipmap.home_tab_match_checked);
                tv_match.setTextColor(Color.parseColor("#f9c134"));
                iv_mine.setImageResource(R.mipmap.home_tab_mine_check);
                tv_mine.setTextColor(Color.parseColor("#9D9D9D"));
                break;
            case 2:
                iv_intelligence.setImageResource(R.mipmap.home_tab_intelligence_check);
                tv_intelligence.setTextColor(Color.parseColor("#9D9D9D"));
                iv_match.setImageResource(R.mipmap.home_tab_match_check);
                tv_match.setTextColor(Color.parseColor("#9D9D9D"));
                iv_mine.setImageResource(R.mipmap.home_tab_mine_checked);
                tv_mine.setTextColor(Color.parseColor("#f9c134"));
                break;
        }
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);

        SupportFragment firstFragment = findFragment(MatchFragment.class);
        if (firstFragment == null) {
            mFragments[Match] = new MatchFragment();

            loadMultipleRootFragment(R.id.home_frame, Match,
                    mFragments[Match]
            );
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用,也可以通过getChildFragmentManager.findFragmentByTag自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[Match] = firstFragment;
        }

        setSelectTabStyle();
    }



    @OnClick(R.id.match)
    public void onClickMatch(){
        showHideFragment(mFragments[1], mFragments[selectIndex]);
        selectIndex=1;
        setSelectTabStyle();
    }


}
