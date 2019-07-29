package com.fengzhi.mykotlindemo.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.fengzhi.mykotlindemo.R
import com.fengzhi.mykotlindemo.bean.MessageBean

class MessageAdapter(layoutResId: Int, data: List<MessageBean>?) :
    BaseQuickAdapter<MessageBean, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder, item: MessageBean) {
        helper.setImageResource(R.id.msg_avatar, item.icon).setText(
            R.id.msg_nickname,
            item.nick
        ).setText(R.id.msg_info, item.msginfo).setText(
            R.id.msg_time,
            item.time
        ).setText(R.id.msg_number, item.mesnumber)
    }
}