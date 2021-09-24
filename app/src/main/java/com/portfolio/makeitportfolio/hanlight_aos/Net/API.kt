package com.portfolio.makeitportfolio.hanlight_aos.Net

import com.portfolio.makeitportfolio.hanlight_aos.Data.Login
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
}