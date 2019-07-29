package com.fengzhi.mykotlindemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fengzhi.mykotlindemo.R
import com.fengzhi.mykotlindemo.base.SlideBackBaseActivity
import kotlinx.android.synthetic.main.toolbar.*

class MyInfoActivity : SlideBackBaseActivity() {
    companion object {
        private val NIKENAME = 1
        private val SEX = 2
        private val BIRTHDAY = 3
        private val PROFESSION = 4
        private val HOBBY = 5
    }

    override fun initView(savedInstanceState: Bundle?) {
       bar_title.setText(R.string.my_info)
    }

    override fun getLayoutResId(): Int = R.layout.activity_my_info


}
