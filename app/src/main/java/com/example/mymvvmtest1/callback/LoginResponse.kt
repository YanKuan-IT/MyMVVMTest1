package com.example.mymvvmtest1.callback

data class LoginResponse(
    val data : LoginDataResponse,
    val errorCode: Int,
    val errorMsg: String
)

data class LoginDataResponse(
    val admin: Boolean,
    val chapterTops: List<*>,
    val coinCount: String,
    val collectIds: List<*>,
    val email: String ?,
    val icon: String?,
    val id: String?,
    val nickname: String?,
    val password: String?,
    val publicName: String?,
    val token: String?,
    val type: Int,
    val username: String?
)