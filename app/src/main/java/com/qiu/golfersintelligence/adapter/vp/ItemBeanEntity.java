package com.qiu.golfersintelligence.adapter.vp;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by a on 2017/3/28.
 */

public class ItemBeanEntity implements MultiItemEntity {

    public static final int TYPE_1=1;
    public  static final int TYPE_2=2;
    public  static final int TYPE_3=3;
    public  static final int TYPE_4=4;
    public  static final int TYPE_5=5;

    public int itemType;

    public Object getObject() {
        return object;
    }

    public Object object;

    public ItemBeanEntity(int itemType, Object o){
        this.itemType=itemType;
        this.object=o;
    }

    @Override
    public int getItemType() {
        return itemType;
    }


}
