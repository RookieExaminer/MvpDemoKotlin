package  com.example.azheng.rxjavamvpdemo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.azheng.rxjavamvpdemo.base.BaseMvpActivity
import com.example.azheng.rxjavamvpdemo.bean.BaseObjectBean
import com.example.azheng.rxjavamvpdemo.bean.LoginBean
import com.example.azheng.rxjavamvpdemo.contract.MainContract
import com.example.azheng.rxjavamvpdemo.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvpActivity<MainPresenter?>(), MainContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

        mPresenter = MainPresenter()
        mPresenter?.attachView(this)

        btn_signin_login.setOnClickListener(View.OnClickListener {
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this@MainActivity, "帐号密码不能为空", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            mPresenter!!.login(username, password)
        })
    }

    override fun initData() {

    }

    /**
     * @return 帐号
     */
    private val username: String
        private get() = et_username_login.text.toString().trim { it <= ' ' }

    /**
     * @return 密码
     */
    private val password: String
        private get() = et_password_login.text.toString().trim { it <= ' ' }

    override fun onSuccess(bean: BaseObjectBean<LoginBean>?) {
        Toast.makeText(this, bean?.errorMsg, Toast.LENGTH_SHORT).show()
    }


    override fun showLoading() {}
    override fun hideLoading() {}
    override fun onError(errMessage: String?) {

    }

}