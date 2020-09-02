package com.example.azheng.rxjavamvpdemo.bean

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：对象
 */
class BaseObjectBean<T> {
    /**
     * status : 1
     * msg : 获取成功
     * result : {} 对象
     */
    var errorCode = 0
    var errorMsg: String? = null
    var result: T? = null
        private set

    fun setResult(result: T) {
        this.result = result
    }
}