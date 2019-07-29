package com.fengzhi.mykotlindemo.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import com.fengzhi.mykotlindemo.R
import com.fengzhi.mykotlindemo.adapter.FunctionAdapter
import com.fengzhi.mykotlindemo.base.BaseFragment
import com.fengzhi.mykotlindemo.bean.HomeFunctionBean
import com.fengzhi.mykotlindemo.util.GlideImageLoader
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_business.*
import kotlinx.android.synthetic.main.toolbar.*
import java.util.*

class HomeFragment : BaseFragment() {
    companion object {
        const val BUSINESS = 1
        const val CLIENT = 4
        val functionImageResIds = intArrayOf(R.mipmap.loan, R.mipmap.investment, R.mipmap.repayment)
        val functionName = arrayOf("借款", "投资", "还款")
    }

    private var mFunctionAdapter: FunctionAdapter? = null
    private val mFunctionDatas = ArrayList<HomeFunctionBean>()//存储主页列表功能

    override fun initView(view: View, savedInstanceState: Bundle?) {
        bar_title.setText(R.string.string_home)
        title_back.visibility = View.GONE
        initFunctionDatas()
        mFunctionAdapter = FunctionAdapter(R.layout.item_function, mFunctionDatas)
        val gridLayoutManager = GridLayoutManager(context, 3)
        gridLayoutManager.isSmoothScrollbarEnabled = true
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = mFunctionAdapter

        mFunctionAdapter?.addHeaderView(showRoleType(BUSINESS))
        //添加线条到列表头部
        mFunctionAdapter?.addHeaderView(showLineView())
        //追加线条
        mFunctionAdapter?.addFooterView(showLineView())

        mFunctionAdapter?.setOnItemClickListener { adapter, view, position ->
            when (position) {
//                0 -> startActivity(LoanActivity.class, null, false);
//                1 -> startActivity(TouZhiActivity::class.java, null, false)
//                2 -> startActivity(RepaymentActivity::class.java, null, false)
//                3 -> startActivity(XueFeiActivity::class.java, null, false)
//                4 -> startActivity(GonGaoActivity::class.java, null, false)
//                5 -> startActivity(GonGaoActivity4::class.java, null, false)
//                6 -> startActivity(GonGaoActivity5::class.java, null, false)
            }
        }
        val images = ArrayList<String>()
        images.add("http://img2.imgtn.bdimg.com/it/u=2711698379,2510140807&fm=26&gp=0.jpg")
        images.add("http://img5.imgtn.bdimg.com/it/u=605435257,2656259734&fm=26&gp=0.jpg")
        images.add("http://img4.imgtn.bdimg.com/it/u=146194547,2303495867&fm=26&gp=0.jpg")
        home_banner.setImageLoader(GlideImageLoader())
        home_banner.setImages(images)
        home_banner.setDelayTime(3000)//设置轮播时间
        home_banner.start()
    }

    private fun initFunctionDatas() {
        mFunctionDatas.clear()
        var homeFunctionBean: HomeFunctionBean
        for (i in 0..2) {
            homeFunctionBean = HomeFunctionBean()
            homeFunctionBean.imageResId = functionImageResIds[i]
            homeFunctionBean.functionName = functionName[i]
            mFunctionDatas.add(homeFunctionBean)
        }
    }

    private fun showRoleType(type: Int): View? {
        var view: View? = null
        if (type == BUSINESS) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_business, null)
            val msales = view!!.findViewById<TextView>(R.id.m_sales)
            val ysales = view.findViewById<TextView>(R.id.y_sales)
            val completiyuanonRate = view.findViewById<TextView>(R.id.completion_rate) //完成率
            msales.text = "借款金额：6000(圆整)"
            ysales.text = "借款期限：150(天)"
            completiyuanonRate.text = "年利率：22%"
            return view
        } else if (type == CLIENT) {
        }
        return null
    }

    private fun showLineView(): View {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_view, null)
        val textView = view.findViewById<TextView>(R.id.line_view)
        textView.setBackgroundResource(R.color.color_f6f6f6)
        return view
    }

    override fun getLayoutResId(): Int = R.layout.fragment_home

}
