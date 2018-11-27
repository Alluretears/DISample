package com.zech.disample

interface LoginCallback {
    fun onSuccess(token: String)
    fun onFailure(error: String)
}