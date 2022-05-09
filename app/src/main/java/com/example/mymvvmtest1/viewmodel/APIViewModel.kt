package com.example.mymvvmtest1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymvvmtest1.logutil.LogUtil
import com.example.mymvvmtest1.repository.APIRepository
import kotlinx.coroutines.launch

class APIViewModel : ViewModel() {
    var rspData = MutableLiveData<String>()

    fun requestLogin(username: String, pwd: String) {
        LogUtil.log("2 APIViewModel")
        viewModelScope.launch {
            LogUtil.log("3 APIViewModel")
            val rst = APIRepository().requestLogin(username, pwd)
            rspData.value = if (rst.errorCode == 0) "登录成功！" else "登录失败，code：${rst.errorCode} , msg: ${rst.errorMsg}"
        }
    }

    fun requestRegister(username: String, pwd: String) {
        viewModelScope.launch {
            val rst = APIRepository().requestRegister(username, pwd, pwd)
            rspData.value = if (rst.errorCode == 0) "注册成功！" else "注册失败，code：${rst.errorCode} , msg: ${rst.errorMsg}"
        }
    }
}