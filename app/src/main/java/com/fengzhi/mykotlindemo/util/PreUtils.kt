package com.fengzhi.mykotlindemo.util

import android.content.Context
import android.content.SharedPreferences

object PreUtils {

    val PRE_NAME = "XIONGEN_PDA"
    internal var preferences: SharedPreferences? = null
    lateinit var instance: PreUtils

    fun putBoolean(context: Context, key: String, value: Boolean) {
        if (preferences == null) preferences = context.getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE)
        preferences!!.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(context: Context, key: String, defValue: Boolean): Boolean {
        if (preferences == null) preferences = context.getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE)
        return preferences!!.getBoolean(key, defValue)
    }

    fun putString(context: Context, key: String, value: String) {
        if (preferences == null) preferences = context.getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE)
        preferences!!.edit().putString(key, value).apply()
    }

    fun getString(context: Context, key: String, defValue: String): String? {
        if (preferences == null) preferences = context.getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE)
        return preferences!!.getString(key, defValue)
    }

    fun putInt(context: Context, key: String, value: Int?) {
        if (preferences == null) preferences = context.getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE)
        preferences!!.edit().putInt(key, value!!).apply()
    }

    fun getInt(context: Context, key: String, defValue: Int?): Int? {
        if (preferences == null) preferences = context.getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE)
        return preferences!!.getInt(key, defValue!!)
    }

    fun cleanAll(context: Context) {
        val pref = context.getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.clear()
        editor.commit()
    }
}