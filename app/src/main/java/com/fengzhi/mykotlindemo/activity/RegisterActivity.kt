package com.fengzhi.mykotlindemo.activity

import android.os.Bundle
import com.fengzhi.mykotlindemo.R
import com.fengzhi.mykotlindemo.base.SlideBackBaseActivity
import kotlinx.android.synthetic.main.toolbar.*

class RegisterActivity : SlideBackBaseActivity() {
    override fun initView(savedInstanceState: Bundle?) {
        bar_title.setText(R.string.string_register)
    }

    override fun getLayoutResId(): Int = R.layout.activity_register

}
