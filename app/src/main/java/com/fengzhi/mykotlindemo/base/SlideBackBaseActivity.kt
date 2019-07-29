package com.fengzhi.mykotlindemo.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import com.fengzhi.mykotlindemo.App
import com.fengzhi.mykotlindemo.R
import me.imid.swipebacklayout.lib.app.SwipeBackActivity

abstract class SlideBackBaseActivity : SwipeBackActivity() {
    protected lateinit var mContext: Context
    protected var setStatusBar: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        mContext = this
        AppManager.addActivity(this)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        initView(savedInstanceState)

        //设置状态栏5.0以上的Android系统才可以设置
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            if (setStatusBar) {
                window.statusBarColor = App.instance.getResources().getColor(R.color.theme_color)
            } else {
                //将View全屏
                window.decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                //将状态栏改成背景色改成透明的
                window.statusBarColor = Color.TRANSPARENT
            }
        }
    }

    protected fun startActivity(activity: Class<*>, bundle: Bundle?, isFinish: Boolean) {
        val intent = Intent()
        intent.setClass(mContext, activity)
        if (bundle != null) intent.putExtras(bundle)
        startActivity(intent)
        if (isFinish) finish()
    }

    protected fun startActivityForResult(
        activity: Class<*>, bundle: Bundle?, requestCode: Int,
        isFinish: Boolean
    ) {
        val intent = Intent()
        intent.setClass(mContext, activity)
        if (bundle != null) intent.putExtras(bundle)
        startActivityForResult(intent, requestCode)
        if (isFinish) finish()
    }

    fun backfinish(view: View) {
        unkeyboard()
        finish()
    }

    fun unkeyboard() {
        try {
            val inputMethodManager = mContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            if (inputMethodManager.isActive) {
                inputMethodManager.hideSoftInputFromWindow((mContext as Activity).currentFocus!!.windowToken, 0)
            }
        } catch (e: Exception) {
        }
    }

    protected abstract fun initView(savedInstanceState: Bundle?)   //初始化

    protected abstract fun getLayoutResId(): Int   //加载布局文件
}