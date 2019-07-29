package com.fengzhi.mykotlindemo.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.fengzhi.mykotlindemo.R
import com.fengzhi.mykotlindemo.adapter.MessageAdapter
import com.fengzhi.mykotlindemo.base.BaseFragment
import com.fengzhi.mykotlindemo.bean.MessageBean
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.toolbar.*
import java.util.ArrayList

class ChatFragment : BaseFragment() {
    private var messageAdapter: MessageAdapter? = null
    private val messageBeans = ArrayList<MessageBean>()
    private lateinit var messageBean: MessageBean
    private val iconImgIDs = intArrayOf(
        R.mipmap.avatar_01,
        R.mipmap.avatar_02,
        R.mipmap.avatar_03,
        R.mipmap.avatar_04,
        R.mipmap.avatar_05,
        R.mipmap.avatar_06,
        R.mipmap.avatar_07
    )
    private val nick = arrayOf("小宝贝", "萌萌哒", "美女1号", "小马哥", "老大", "666", "哈喽")
    private val info = arrayOf("不错哈", "我要飞得更高", "这有点帅,不好意思了", "小伙子有前途啊", "啦啦啦", "有前途", "加油")
    private val time = arrayOf("21:32", "20:23", "20:03", "18:58", "15:42", "15:02", "10:48")
    private val number = arrayOf("3", "16", "2", "5", "1", "3", "6", "12", "2", "1")

    override fun initView(view: View, savedInstanceState: Bundle?) {
        bar_title.setText(R.string.string_chat)
        title_back.visibility = View.GONE
        recyclerView.setLayoutManager(LinearLayoutManager(mContext))
        initData()
        messageAdapter = MessageAdapter(R.layout.msg_list_item, messageBeans)
//        messageAdapter.setOnItemClickListener { adapter, view, position ->
//            startActivity(
//                MyInfoActivity::class.java,
//                null,
//                false
//            )
//        }
        recyclerView.adapter = messageAdapter
    }

    private fun initData() {
        messageBeans.clear()
        for (i in 0..6) {
            messageBean = MessageBean()
            messageBean.icon = (iconImgIDs[i])
            messageBean.nick = (nick[i])
            messageBean.msginfo=(info[i])
            messageBean.time=(time[i])
            messageBean.mesnumber=(number[i])
            messageBeans.add(messageBean)
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_chat

}
