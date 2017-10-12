package com.qiu.golfersintelligence.dialog;


import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.qiu.golfersintelligence.R;


/**
 * 进度条工具类
 */
public class LoadingProgress extends Dialog{

    private  Context mContext;
    private ImageView iv_loding;

    public LoadingProgress(Context context) {
        super(context,R.style.loadDataDialogStyle);
        this.mContext=context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

    }

    public void initView(){
        View loadingView = View.inflate(mContext, R.layout.dialog_net_loading, null);
        setContentView(loadingView);
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT; // 高度设置为屏幕的0.2
        lp.height =WindowManager.LayoutParams.WRAP_CONTENT;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        dialogWindow.setAttributes(lp);

        iv_loding=loadingView.findViewById(R.id.iv_loding);

        ((AnimationDrawable)iv_loding.getDrawable()).start();
    }
}