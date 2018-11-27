package com.zech.disample

class FakeApiServiceImpl : ApiService {
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