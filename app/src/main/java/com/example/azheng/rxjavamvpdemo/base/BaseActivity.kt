package com.example.azheng.rxjavamvpdemo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    /**
     * 设置布局
     *
     * @return
     */
    protected  abstract fun getLayoutId(): Int

    /**
     * 初始化视图
     */
    protected  abstract fun initView()
    /**
     * 初始化数据
     */
    protected   abstract fun initData()
}