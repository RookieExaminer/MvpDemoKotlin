package com.example.azheng.rxjavamvpdemo.presenter

import autodispose2.ObservableSubscribeProxy
import autodispose2.autoDispose
import com.example.azheng.rxjavamvpdemo.base.BasePresenter
import com.example.azheng.rxjavamvpdemo.bean.BaseObjectBean
import com.example.azheng.rxjavamvpdemo.bean.LoginBean
import com.example.azheng.rxjavamvpdemo.contract.MainContract
import com.example.azheng.rxjavamvpdemo.contract.MainContract.Presenter
import com.example.azheng.rxjavamvpdemo.model.MainModel
import com.example.azheng.rxjavamvpdemo.net.RxScheduler
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

/**
 * @author azheng
 * @date 2018/6/4.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
class MainPresenter : BasePresenter<MainContract.View?>(), Presenter {
    private val model: MainContract.Model
    override fun login(username: String?, password: String?) {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached) {
            return
        }
        model.login(username, password)
                .compose(RxScheduler.Obs_io_main())
                .to(mView?.bindAutoDispose<BaseObjectBean<LoginBean>>())
                .subscribe(object : Observer<BaseObjectBean<LoginBean>> {
                    override fun onSubscribe(d: @NonNull Disposable?) {
                        mView?.showLoading()
                    }

                    override fun onNext(loginBeanBaseObjectBean: BaseObjectBean<LoginBean>) {
                        mView?.onSuccess(loginBeanBaseObjectBean)
                    }

                    override fun onError(e: @NonNull Throwable?) {
                        mView?.onError(e!!.message)
                        mView?.hideLoading()
                    }

                    override fun onComplete() {
                        mView?.hideLoading()
                    }


                })
    }

    init {
        model = MainModel()
    }
}