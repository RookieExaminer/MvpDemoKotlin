package com.example.azheng.rxjavamvpdemo.net

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.FlowableTransformer
import io.reactivex.rxjava3.core.ObservableTransformer
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * @author azheng
 * @date 2018/4/16.
 * GitHub：https://github.com/RookieExaminer
 * email：wei.azheng@foxmail.com
 * description：RXjava 线程调度
 */
object RxScheduler {
    /**
     * 统一线程处理
     *
     * @param <T> 指定的泛型类型
     * @return FlowableTransformer
    </T> */
    fun <T> Flo_io_main(): FlowableTransformer<T, T> {
        return FlowableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    /**
     * 统一线程处理
     *
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
    </T> */
    fun <T> Obs_io_main(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }
}