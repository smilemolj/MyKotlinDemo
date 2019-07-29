package com.fengzhi.mykotlindemo.activity

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.fengzhi.mykotlindemo.R
import com.fengzhi.mykotlindemo.base.SlideBackBaseActivity
import kotlinx.android.synthetic.main.activity_forgetpsw.*
import kotlinx.android.synthetic.main.toolbar.*

class ForgetpswActivity : SlideBackBaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.submit_psw -> {
                val account = account_ET.text.toString().trim { it <= ' ' }
                val phone = phone_ET.text.toString().trim { it <= ' ' }
                val password = set_psw.text.toString().trim { it <= ' ' }
                val confirmPassword = confirm_psw.text.toString().trim { it <= ' ' }
                if (TextUtils.isEmpty(account) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(password) || TextUtils.isEmpty(
                        confirmPassword
                    )
                ) Toast.makeText(this, "请输入完整信息", Toast.LENGTH_SHORT).show()
                else {
                    //            model.doForgetpsw(account,phone,password,confirmPassword);
                }
            }
        }
    }

    override fun initView(savedInstanceState: Bundle?) = bar_title.setText(R.string.string_forgetpsw)

    override fun getLayoutResId(): Int = R.layout.activity_forgetpsw


}
