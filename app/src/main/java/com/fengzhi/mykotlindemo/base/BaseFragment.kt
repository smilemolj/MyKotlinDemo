package com.fengzhi.mykotlindemo.base

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    protected lateinit var mContext: Context
    protected lateinit var progressDialog: ProgressDialog
    protected var orVisible: Boolean = false
    protected var isPrepared: Boolean = false
    protected var isOnactivitycreate: Boolean = false
    protected var isLoadData: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayoutResId(), container, false)
        mContext = requireActivity()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view, savedInstanceState)
    }

    protected fun showLoadingDialog(message: String) {
        progressDialog = ProgressDialog(mContext)
        progressDialog.setMessage(message)
        progressDialog.setCancelable(false)
        if (!requireActivity().isFinishing()) {
            progressDialog.show()
        }
    }

    protected fun dismissLoadingDialog() {
        if (progressDialog.isShowing) progressDialog.dismiss()
    }

    fun startActivity(activity: Class<*>, bundle: Bundle?, isFinish: Boolean) {
        val intent = Intent()
        intent.setClass(requireActivity(), activity)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        requireActivity().startActivity(intent)
        if (isFinish) requireActivity().finish()
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

    protected abstract fun initView(view: View, savedInstanceState: Bundle?)

    @LayoutRes
    protected abstract fun getLayoutResId(): Int

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        orVisible = isVisibleToUser
        if (userVisibleHint) {
            orVisible = true
            onVisible()
        } else {
            orVisible = false
        }
    }

    private fun onVisible() {
        lazyLoad()
    }

    protected fun lazyLoad() {}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (!isOnactivitycreate) {
            isOnactivitycreate = true
            lazyLoad()
        }
    }
}