package com.zech.disample

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeApiServiceImpl @Inject constructor() : ApiService {
    override fun login(
        userName: String,
        password: String,
        callback: LoginCallback
    ) {
        if ("zech" == userName && "12345678" == password) {
            callback.onSuccess("token")
        } else {
            callback.onFailure("userName is not found")
        }
    }
}