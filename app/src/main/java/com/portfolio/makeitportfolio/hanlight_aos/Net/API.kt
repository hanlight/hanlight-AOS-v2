package com.portfolio.makeitportfolio.hanlight_aos.Net

import com.portfolio.makeitportfolio.hanlight_aos.Data.Login
import com.portfolio.makeitportfolio.hanlight_aos.Data.SearchPassword
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface API {
    @FormUrlEncoded
    @POST("/user/login")
    fun login(
        @Field("id") id: String,
        @Field("password") password: String
    ): retrofit2.Call<Login>

    @FormUrlEncoded
    @POST("/user/register")
    fun register(
        @Field("id") id: String,
        @Field("password") pw: String,
        @Field("signKey") key: String
    ): retrofit2.Call<Void>

    @FormUrlEncoded
    @POST("/user/sms")
    fun sms(
        @Field("phone") phone: String
    ): retrofit2.Call<String>

    @FormUrlEncoded
    @POST("/user/recovery/id")
    fun searchId(
        @Field("code") code: String
    ): retrofit2.Call<Void>

    @FormUrlEncoded
    @POST("/user/recovery/password")
    fun searchPassword(
        @Field("code") code: String,
        @Field("id") id: String
    ): retrofit2.Call<SearchPassword>
}