package com.fengzhi.mykotlindemo

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.fengzhi.mykotlindemo.Constants.Constants.FragmentType.FARGMENT_CONTACT
import com.fengzhi.mykotlindemo.Constants.Constants.FragmentType.FARGMENT_HOME
import com.fengzhi.mykotlindemo.Constants.Constants.FragmentType.FARGMENT_MINE
import com.fengzhi.mykotlindemo.Constants.Constants.FragmentType.FRAGMENT_CHAT
import com.fengzhi.mykotlindemo.base.BaseActivity
import com.fengzhi.mykotlindemo.fragment.ChatFragment
import com.fengzhi.mykotlindemo.fragment.ContactFragment
import com.fengzhi.mykotlindemo.fragment.HomeFragment
import com.fengzhi.mykotlindemo.fragment.MineFragment
import com.fengzhi.mykotlindemo.util.BottomNavigationViewHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private var lastClickTime: Long = 0
    private var homeFragment: HomeFragment? = null
    private var chatFragment: ChatFragment? = null
    private var contactFragment: ContactFragment? = null
    private var mineFragment: MineFragment? = null
    override fun initView(savedInstanceState: Bundle?) {
        setStatusBar = true
        BottomNavigationViewHelper.disableShiftMode(bottom_naigation)
        bottom_naigation.setSelectedItemId(bottom_naigation.getMenu().getItem(FARGMENT_HOME).getItemId())
        bottom_naigation.setSelectedItemId(R.id.action_home)
        showFragment(FARGMENT_HOME)
        bottom_naigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> showFragment(FARGMENT_HOME)
                R.id.action_order -> showFragment(FRAGMENT_CHAT)
                R.id.action_followorder -> showFragment(FARGMENT_CONTACT)
                R.id.action_business -> showFragment(FARGMENT_MINE)
            }
            true
        }
    }

    private fun showFragment(type: Int) {
        val ft = supportFragmentManager.beginTransaction()
        hideFragment(ft)
        when (type) {
            FRAGMENT_CHAT -> if (chatFragment == null) {
                chatFragment = ChatFragment()
                ft.add(R.id.container, chatFragment!!, ChatFragment::class.java.name)
            } else {
                ft.show(chatFragment!!)
            }
            FARGMENT_HOME -> if (homeFragment == null) {
                homeFragment = HomeFragment()
                ft.add(R.id.container, homeFragment!!, HomeFragment::class.java.name)
            } else {
                ft.show(homeFragment!!)
            }
            FARGMENT_CONTACT -> if (contactFragment == null) {
                contactFragment = ContactFragment()
                ft.add(R.id.container, contactFragment!!, ContactFragment::class.java.name)
            } else {
                ft.show(contactFragment!!)
            }
            FARGMENT_MINE -> if (mineFragment == null) {
                mineFragment = MineFragment()
                ft.add(R.id.container, mineFragment!!, MineFragment::class.java.name)
            } else {
                ft.show(mineFragment!!)
            }
        }
        ft.commit()
    }

    private fun hideFragment(fragmentTransaction: FragmentTransaction) {
        //如果不为空，就先隐藏起来
        if (chatFragment != null) fragmentTransaction.hide(chatFragment!!)
        if (homeFragment != null) fragmentTransaction.hide(homeFragment!!)
        if (contactFragment != null) fragmentTransaction.hide(contactFragment!!)
        if (mineFragment != null) fragmentTransaction.hide(mineFragment!!)
    }


    override fun onBackPressed() {
        super.onBackPressed()
        if (lastClickTime <= 0) {
            Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show()
            lastClickTime = System.currentTimeMillis()
        } else {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastClickTime < 2000) finish()
            else lastClickTime = System.currentTimeMillis()
        }
    }

    override fun getLayoutResId(): Int = R.layout.activity_main

}
