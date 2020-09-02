package com.example.azheng.rxjavamvpdemo.bean

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：数组
 */
class BaseArrayBean<T> {
    /**
     * status : 1
     * msg : 获取成功
     * result : [] 数组
     */
    var errorCode = 0
    var errorMsg: String? = null
    var result: List<T>? = null

}