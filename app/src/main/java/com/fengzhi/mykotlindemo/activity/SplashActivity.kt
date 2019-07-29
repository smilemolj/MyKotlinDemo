package com.fengzhi.mykotlindemo.activity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.RelativeLayout
import com.fengzhi.mykotlindemo.Constants.Constants
import com.fengzhi.mykotlindemo.R
import com.fengzhi.mykotlindemo.util.NetWorkStateUtil
import com.fengzhi.mykotlindemo.util.PreUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.statusBarColor = Color.TRANSPARENT
        }
        setContentView(R.layout.activity_splash)
        //初始化动画
        initAnmi()
    }

    private fun initAnmi() {
        //透明度动画
        val alpha = AlphaAnimation(0f, 1f)
        alpha.duration = 2000 //设置动画时长
        alpha.fillAfter = true //动画运行完成保留结束时状态
        //监听动画
        alpha.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                //网络可用的情况下判断用户密码有没有在其他应用端被修改过
                if (NetWorkStateUtil.isNetworkAvailable(this@SplashActivity)) {
                    Constants.HOST_URL = PreUtils.getString(
                        this@SplashActivity,
                        Constants.PRE_SERVER, ""
                    ).toString()
                    val username = PreUtils.getString(
                        this@SplashActivity,
                        "account", ""
                    )
                    val password = PreUtils.getString(
                        this@SplashActivity,
                        "password", ""
                    )
                    if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password)) {
                        return
                    }
                    //                    model.doLogin(username, password);
                }
            }

            override fun onAnimationEnd(animation: Animation) {
                //动画运行完进入下一个页面
                val userId = PreUtils.getInt(
                    this@SplashActivity,
                    "userId", 0
                )
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                overridePendingTransition(R.anim.fade_in_500, R.anim.fade_out_500)
                finish()
                return
            }

            override fun onAnimationRepeat(animation: Animation) {

            }
        })

        relative_layout.startAnimation(alpha)
    }
}
