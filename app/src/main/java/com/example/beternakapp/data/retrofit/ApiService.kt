package com.example.beternakapp.data.retrofit

import com.example.beternakapp.data.response.ProductResponse
import com.example.beternakapp.data.response.UserResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @GET("product/all")
    fun getData(): Call<ProductResponse>

    @FormUrlEncoded
    @POST("login")
    fun postLoginResponse(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<UserResponse>
}