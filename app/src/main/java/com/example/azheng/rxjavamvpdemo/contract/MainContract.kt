package com.example.azheng.rxjavamvpdemo.contract

import com.example.azheng.rxjavamvpdemo.base.BaseView
import com.example.azheng.rxjavamvpdemo.bean.BaseObjectBean
import com.example.azheng.rxjavamvpdemo.bean.LoginBean
import io.reactivex.rxjava3.core.Observable

/**
 * @author azheng
 * @date 2018/6/4.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
interface MainContract {
    interface Model {
        fun login(username: String?, password: String?): Observable<BaseObjectBean<LoginBean>>
    }

    interface View : BaseView {
        override fun showLoading()
        override fun hideLoading()
        override fun onError(errMessage: String?)
        fun onSuccess(bean: BaseObjectBean<LoginBean>?)
    }

    interface Presenter {
        /**
         * 登陆
         *
         * @param username
         * @param password
         */
        fun login(username: String?, password: String?)
    }
}