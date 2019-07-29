package com.fengzhi.mykotlindemo.fragment


import android.os.Bundle
import android.view.View
import com.fengzhi.mykotlindemo.R
import com.fengzhi.mykotlindemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_mine.*

class MineFragment : BaseFragment() {
    override fun initView(view: View, savedInstanceState: Bundle?) {
        bar_title.setText(R.string.string_contact)
    }


    override fun getLayoutResId(): Int = R.layout.fragment_mine

}
