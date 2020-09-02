package com.example.azheng.rxjavamvpdemo.base

import autodispose2.AutoDisposeConverter

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
interface BaseView {
    /**
     * 显示加载中
     */
    fun showLoading()

    /**
     * 隐藏加载
     */
    fun hideLoading()

    /**
     * 数据获取失败
     * @param errMessage
     */
    fun onError(errMessage: String?)

    /**
     * 绑定Android生命周期 防止RxJava内存泄漏
     *
     * @param <T>
     * @return
    </T> */
    fun <T> bindAutoDispose(): AutoDisposeConverter<T>?
}