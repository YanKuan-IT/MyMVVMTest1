package com.example.mymvvmtest1.api

import com.example.mymvvmtest1.callback.LoginResponse
import com.example.mymvvmtest1.callback.RegisterResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TestApi {
    @POST("/user/login")
    @FormUrlEncoded
    suspend fun loginAction(@Field("username") username : String,
                            @Field("password") password : String) : LoginResponse

    @POST("/user/register")
    @FormUrlEncoded
    suspend fun registerAction(@Field("username") username : String,
                               @Field("password") password : String,
                               @Field("repassword") repassword : String) : RegisterResponse
}