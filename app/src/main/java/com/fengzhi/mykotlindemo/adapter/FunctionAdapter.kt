package com.fengzhi.mykotlindemo.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.fengzhi.mykotlindemo.R
import com.fengzhi.mykotlindemo.bean.HomeFunctionBean

class FunctionAdapter(layoutResId: Int, data: List<HomeFunctionBean>?) :
    BaseQuickAdapter<HomeFunctionBean, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder, item: HomeFunctionBean) {
        helper.setImageResource(R.id.function_img, item.imageResId)
        helper.setText(R.id.function_name, item.functionName)
    }
}
