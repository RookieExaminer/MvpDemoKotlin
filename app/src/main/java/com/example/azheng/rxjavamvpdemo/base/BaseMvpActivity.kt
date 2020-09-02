package com.example.azheng.rxjavamvpdemo.base

import android.os.Bundle
import androidx.lifecycle.Lifecycle
import autodispose2.AutoDispose
import autodispose2.AutoDisposeConverter
import autodispose2.androidx.lifecycle.AndroidLifecycleScopeProvider

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
abstract class BaseMvpActivity<T : BasePresenter<*>?> : BaseActivity(), BaseView {
    protected var mPresenter: T? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        if (mPresenter != null) {
            mPresenter?.detachView()
        }
        super.onDestroy()
    }

    /**
     * 绑定生命周期 防止MVP内存泄漏
     *
     * @param <T>
     * @return
    </T> */
    override fun <T> bindAutoDispose(): AutoDisposeConverter<T>? {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider
                .from(this, Lifecycle.Event.ON_DESTROY))
    }
}