package com.qiu.golfersintelligence.adapter.vp;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qiu.golfersintelligence.R;

import java.util.List;

/**
 * Created by a on 2017/9/19.
 */

public class IntelligenceListAdapter extends BaseMultiItemQuickAdapter<ItemBeanEntity,BaseViewHolder> {


    public IntelligenceListAdapter(List<ItemBeanEntity> data) {
        super(data);
        addItemType(ItemBeanEntity.TYPE_1, R.layout.intelligence_list_item);
    }

    @Override
    protected void convert(final BaseViewHolder holder, ItemBeanEntity itemBeanEntity) {
        switch (itemBeanEntity.getItemType()) {
            case ItemBeanEntity.TYPE_1:
                break;
        }
    }

}
