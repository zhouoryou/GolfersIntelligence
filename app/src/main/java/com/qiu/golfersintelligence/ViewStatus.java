package com.qiu.golfersintelligence;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.math.BigDecimal;


/**
 * Created by a on 2017/9/21.
 */

public class ViewStatus {

    private Context mContext;

    /**
     * 加载之前的view;
     */
    private View loadBeforeView;

    /**
     * 没有数据的view
     */
    private View noDataView;

    public ViewStatus(Context mContext){
        this.mContext=mContext;
    }


    /**
     * 加载数据之前没有数据的view
     */
    public View getLoadBeforeView(Context mContext,int img) {
        return getLoadBeforeView(mContext,img,3312);
    }

    public View getLoadBeforeView(Context mContext,int img,int imgHeight) {
        if(loadBeforeView==null){
            loadBeforeView=new ImageView(mContext);
            loadBeforeView.setBackgroundResource(img);
            WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            int w=wm.getDefaultDisplay().getWidth();
            double height= mul(div(w,1082,2),imgHeight);
            loadBeforeView.setLayoutParams(new RelativeLayout.LayoutParams(w, (int)height));
        }
        return loadBeforeView;
    }


    public  double div(double v1,double v2,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public  double mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }



    /**
     * 初始化没有数据的view
     */
    public View getNoDataView(String message){
        if(noDataView==null){
            noDataView=View.inflate(mContext,R.layout.view_no_data,null);
        }
        return noDataView;
    }

}
