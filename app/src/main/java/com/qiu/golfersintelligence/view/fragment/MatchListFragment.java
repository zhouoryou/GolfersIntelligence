package com.qiu.golfersintelligence.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qiu.golfersintelligence.R;
import com.qiu.golfersintelligence.ViewStatus;
import com.qiu.golfersintelligence.adapter.vp.ItemBeanEntity;
import com.qiu.golfersintelligence.adapter.vp.MatchListAdapter;
import com.qiu.golfersintelligence.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by a on 2017/9/22.
 */

public class MatchListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    private Context mContext;
    private MatchListAdapter matchListAdapter;
    private List<ItemBeanEntity> mlist=new ArrayList<ItemBeanEntity>();
    private ViewStatus viewStatus;
    private HeadViewHolder headViewHolder;

    @BindView(R.id.recycleview)
    public RecyclerView recycleview;
    @BindView(R.id.refresh)
    public SwipeRefreshLayout refresh;
    @BindView(R.id.lin_time_list)
    public LinearLayout lin_time_list;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext=activity;
    }

    public int getFragmentPos(){
        return getArguments().getInt("position");
    }

    @Override
    public int bindLayout() {
        return R.layout.match_list_fragment;
    }

    @Override
    public void initView(View view) {
        ButterKnife.bind(this,view);
        viewStatus=new ViewStatus(mContext);
        initRefresh();
        initAdapter();
    }

    public void initAdapter(){
        recycleview.setLayoutManager(new LinearLayoutManager(mContext));
        matchListAdapter=new MatchListAdapter(mlist);
        recycleview.setAdapter(matchListAdapter);
        matchListAdapter.setHeaderFooterEmpty(true,true);
        View headView=View.inflate(mContext,R.layout.match_list_head_view,null);
        headViewHolder=new HeadViewHolder(headView);
        matchListAdapter.addHeaderView(headView);
        headViewHolder.fra_load_failure.removeAllViews();
        headViewHolder.fra_load_failure.addView(viewStatus.getLoadBeforeView(mContext,R.mipmap.match_list_load_before_bg));
    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        refresh.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                headViewHolder.fra_load_failure.setVisibility(View.GONE);
                if(mlist.size()>0){
                    mlist.clear();
                    if(getFragmentPos()!=2){
                        matchListAdapter.setEmptyView(viewStatus.getNoDataView("赛事都没有，人生毫无意义"));
                    }else {
                        matchListAdapter.setEmptyView(viewStatus.getNoDataView("你暂时还没有订阅情报哦"));
                    }
                }else{
                    mlist.add(new ItemBeanEntity(ItemBeanEntity.TYPE_1,null));
                    mlist.add(new ItemBeanEntity(ItemBeanEntity.TYPE_2,null));
                    mlist.add(new ItemBeanEntity(ItemBeanEntity.TYPE_2,null));
                    mlist.add(new ItemBeanEntity(ItemBeanEntity.TYPE_2,null));
                    mlist.add(new ItemBeanEntity(ItemBeanEntity.TYPE_2,null));
                    matchListAdapter.notifyDataSetChanged();
                }
                refresh.setRefreshing(false);
            }
        }, 1000);
    }

    public class  TimeListHolder{

        @BindView(R.id.tv_week)
        public TextView tv_week;
        @BindView(R.id.tv_date)
        public TextView tv_date;

        public TimeListHolder(View view){
            ButterKnife.bind(this,view);
        }

    }


    /**
     * 初始化头部view
     */
    public class  HeadViewHolder{
        @BindView(R.id.fra_load_failure)
        public FrameLayout fra_load_failure;
        @BindView(R.id.lin_date_list)
        public LinearLayout lin_date_list;
        public HeadViewHolder(View view){
            ButterKnife.bind(this,view);
            if(getFragmentPos()==1){
                lin_date_list.setVisibility(View.VISIBLE);
            }else{
                lin_date_list.setVisibility(View.GONE);
            }
        }
    }

    public void initRefresh(){
        refresh.setOnRefreshListener(this);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        refresh.setRefreshing(true);
        onRefresh();
    }

}
