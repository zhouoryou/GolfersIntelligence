package com.qiu.golfersintelligence.adapter.vp;


import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qiu.golfersintelligence.R;

import java.util.List;

/**
 * Created by a on 2017/9/22.
 */

public class MatchListAdapter extends BaseMultiItemQuickAdapter<ItemBeanEntity,BaseViewHolder> {


    public MatchListAdapter(List data) {
        super(data);
        addItemType(ItemBeanEntity.TYPE_1, R.layout.match_list_time);
        addItemType(ItemBeanEntity.TYPE_2, R.layout.match_list_item);
    }

    @Override
    protected void convert(BaseViewHolder holder, ItemBeanEntity itemBeanEntity) {
        switch (itemBeanEntity.getItemType()){
            case ItemBeanEntity.TYPE_1:

                break;
            case ItemBeanEntity.TYPE_2:

                break;
        }
    }
}
