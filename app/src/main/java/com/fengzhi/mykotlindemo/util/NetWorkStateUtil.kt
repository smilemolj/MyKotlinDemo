package com.fengzhi.mykotlindemo.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetWorkStateUtil {
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivity = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivity.activeNetworkInfo
        if (info != null && info.isConnected) {
            // 当前网络是连接的
            if (info.state == NetworkInfo.State.CONNECTED) {
                // 当前所连接的网络可用
                return true
            }
        }
        return false
    }
}