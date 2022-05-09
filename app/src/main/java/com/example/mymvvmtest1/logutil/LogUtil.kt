package com.example.mymvvmtest1.logutil

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

object LogUtil {
    private val TAG = "AAAAAAAAAAAAAAA"
    private val now = {
        SimpleDateFormat("HH:mm:ss:SSS").format(Date(System.currentTimeMillis()))
    }
    fun log(str : Any?) = Log.d(TAG, "${now()} [${Thread.currentThread().name}] $str")
}