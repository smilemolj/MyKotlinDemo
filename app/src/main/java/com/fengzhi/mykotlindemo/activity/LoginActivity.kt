package com.fengzhi.mykotlindemo.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.fengzhi.mykotlindemo.MainActivity
import com.fengzhi.mykotlindemo.R
import com.fengzhi.mykotlindemo.base.BaseActivity
import com.fengzhi.mykotlindemo.view.ILoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), ILoginView {

    override fun initView(savedInstanceState: Bundle?) {
        registered.setOnClickListener(onClickListener)
        forget_psw.setOnClickListener(onClickListener)
        btn_login.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.registered -> startActivity(RegisterActivity::class.java, null, false)
            R.id.forget_psw -> startActivity(ForgetpswActivity::class.java, null, false)
            R.id.btn_login -> {
                if (user_name.getText().toString() != "" && pass_word.getText().toString() != "") {
                    //                    loginModel.doLogin(et_userName.getText().toString(),
                    //                            et_passWord.getText().toString());
                    startActivity(MainActivity::class.java, null, false)
                    finish()
                } else Toast.makeText(mContext, "用户名密码不能为空", Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun getLayoutResId(): Int = R.layout.activity_login
}
