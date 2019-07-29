package com.fengzhi.mykotlindemo.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.fengzhi.mykotlindemo.R
import com.fengzhi.mykotlindemo.adapter.ContactAdapter
import com.fengzhi.mykotlindemo.base.BaseFragment
import com.fengzhi.mykotlindemo.bean.ContactBean
import kotlinx.android.synthetic.main.fragment_contact.*
import kotlinx.android.synthetic.main.toolbar.*
import java.util.ArrayList

class ContactFragment : BaseFragment() {
    private var contactAdapter: ContactAdapter? = null
    private val contactBeans = ArrayList<ContactBean>()
    private var contactBean: ContactBean? = null
    private val iconImgIDs = intArrayOf(
        R.mipmap.headimg, R.mipmap.headimg, R.mipmap.headimg, R.mipmap.headimg, R.mipmap.headimg,
        R.mipmap.headimg, R.mipmap.headimg, R.mipmap.headimg, R.mipmap.headimg, R.mipmap.headimg
    )
    private val nick = arrayOf("小宝贝", "小宝贝", "小宝贝", "小宝贝", "小宝贝", "小宝贝", "小宝贝", "小宝贝", "小宝贝", "小宝贝")
    private val sex = arrayOf("女", "女", "女", "女", "女", "女", "女", "女", "女", "女")
    override fun initView(view: View, savedInstanceState: Bundle?) {
        bar_title.setText(R.string.string_contact)
        title_back.visibility = View.GONE
        recyclerView.layoutManager = LinearLayoutManager(mContext)
        initData()
        contactAdapter = ContactAdapter(R.layout.item_contact, contactBeans)
//        contactAdapter.setOnItemClickListener { adapter, view, position ->
//            startActivity(
//                MyInfoActivity::class.java,
//                null,
//                false
//            )
//        }
        recyclerView.adapter = contactAdapter
    }

    private fun initData() {
        contactBeans.clear()
        for (i in 0..9) {
            contactBean = ContactBean()
            contactBean!!.icon = (iconImgIDs[i])
            contactBean!!.nick = (nick[i])
            contactBean!!.sex = (sex[i])
            contactBeans.add(contactBean!!)
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_contact

}
