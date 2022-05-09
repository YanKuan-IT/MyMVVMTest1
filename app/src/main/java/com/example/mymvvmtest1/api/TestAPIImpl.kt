package com.example.mymvvmtest1.api

import com.example.mymvvmtest1.logutil.LogUtil
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class TestAPIImpl {
    private object Holder {
        val INSTANCE = TestAPIImpl()
    }

    companion object {
        val instance = Holder.INSTANCE
    }

    fun <T> instanceRetrofit(apiInterface : Class<T>) : T {
        LogUtil.log("5 TestAPIImpl")
        val mOkHttpClient = OkHttpClient().newBuilder()
            .myApply {
                readTimeout(10000, TimeUnit.SECONDS)
                connectTimeout(10000, TimeUnit.SECONDS)
                writeTimeout(10000, TimeUnit.SECONDS)
            }.build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com")
            .client(mOkHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(apiInterface)
    }
}

fun <T> T.myApply(action : T.() -> Unit) : T {
    action()
    return this
}