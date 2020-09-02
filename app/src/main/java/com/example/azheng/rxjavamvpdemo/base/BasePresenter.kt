package com.example.azheng.rxjavamvpdemo.base

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
open class BasePresenter<V : BaseView?> {
    protected var mView: V? = null

    /**
     * 绑定view，一般在初始化中调用该方法
     *
     * @param view view
     */
    fun attachView(view: V) {
        mView = view
    }

    /**
     * 解除绑定view，一般在onDestroy中调用
     */
    fun detachView() {
        mView = null
    }

    /**
     * View是否绑定
     *
     * @return
     */
    val isViewAttached: Boolean
        get() = mView != null
}