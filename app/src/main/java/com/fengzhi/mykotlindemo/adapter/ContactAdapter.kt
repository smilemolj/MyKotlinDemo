package com.fengzhi.mykotlindemo.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.fengzhi.mykotlindemo.R
import com.fengzhi.mykotlindemo.bean.ContactBean

class ContactAdapter(layoutResId: Int, data: List<ContactBean>?) :
    BaseQuickAdapter<ContactBean, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder, item: ContactBean) {
        helper.setImageResource(R.id.img_icon, item.icon)
            .setText(R.id.text_title, "昵称：" + item.nick)
            .setText(R.id.text_sex, "性别：" + item.sex)
    }
}