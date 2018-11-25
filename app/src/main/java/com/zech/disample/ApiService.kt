package com.zech.disample

interface ApiService {
  fun login(
    userName: String,
    password: String,
    callback: LoginCallback
  )
}


