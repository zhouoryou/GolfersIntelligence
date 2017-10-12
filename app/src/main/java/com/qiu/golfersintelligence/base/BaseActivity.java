package com.qiu.golfersintelligence.base;

import android.os.Bundle;

import com.qiu.golfersintelligence.dialog.LoadingProgress;


/**
 * Created by a on 2017/9/18.
 * activity基类
 */

public abstract class BaseActivity extends me.yokeyword.fragmentation.SupportActivity{

    public LoadingProgress loadingProgress;


    /**
     * 用来标记取消。
     */
    private Object object = new Object();

    /**
     * 请求队列。
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        loadingProgress=new LoadingProgress(this);
        initView();
    }






    /**
     * [绑定布局]
     *
     * @return
     */
    public abstract int bindLayout();

    /**
     * [初始化控件]
     */
    public abstract void initView();




}
