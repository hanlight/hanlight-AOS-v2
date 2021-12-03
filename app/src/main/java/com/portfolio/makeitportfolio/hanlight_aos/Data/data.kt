package com.portfolio.makeitportfolio.hanlight_aos.Data

import android.graphics.drawable.Drawable

data class Login(
    val success: Boolean,
    val data: Data
)

data class Data(
    val accessToken: String,
    val user: User
)

data class User(
    val type: String,
    val admin: Int,
    val name: String,
    val id: String,
    val major: String,
    val grade: Int,
    val classNum: Int,
    val studentNum: Int
)

data class SearchPassword(
    val success: Boolean,
    val accessToken: String,
    val refreshToken: String
)

data class notice(
    val title: String,
    val content: String,
    val createAt: String
)

data class popContent(
    val profilePic: Int,
    val name : String,
    val date : String,
    val contentsPic : Int,
    val content : String
)

data class timeTable(
    val firstSub: String,
    val firstName: String
)