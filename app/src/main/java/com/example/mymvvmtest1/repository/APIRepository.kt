package com.example.mymvvmtest1.repository

import com.example.mymvvmtest1.api.TestAPIImpl
import com.example.mymvvmtest1.api.TestApi
import com.example.mymvvmtest1.callback.LoginResponse
import com.example.mymvvmtest1.callback.RegisterResponse
import com.example.mymvvmtest1.logutil.LogUtil

class APIRepository {
    suspend fun requestLogin(username: String, pwd: String) : LoginResponse {
        LogUtil.log("4 APIRepository")
        return TestAPIImpl.instance.instanceRetrofit(TestApi::class.java).loginAction(username, pwd)
    }

    suspend fun requestRegister(username: String, pwd: String, repwd: String) : RegisterResponse {
        return TestAPIImpl.instance.instanceRetrofit(TestApi::class.java).registerAction(username, pwd, repwd)
    }
}