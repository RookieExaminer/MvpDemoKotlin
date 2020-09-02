package com.example.azheng.rxjavamvpdemo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
abstract class BaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(layoutId, container, false)
        initView(view)
        return view
    }

    /**
     * 初始化视图
     *
     * @param view
     */
    protected abstract fun initView(view: View?)
    protected abstract val layoutId: Int
    /**
     * 初始化数据
     */
    protected  abstract fun initData()
}