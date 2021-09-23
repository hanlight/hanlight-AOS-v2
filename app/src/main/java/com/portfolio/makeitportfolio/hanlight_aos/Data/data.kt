package com.portfolio.makeitportfolio.hanlight_aos.Data

data class Login(
    val success : Boolean,
    val data : Data
)

data class Data(
    val accessToken : Boolean,
    val user : User
)

data class User(
    val type : String,
    val admin : Int,
    val name : String,
    val id : String,
    val major : String,
    val grade : Int,
    val classNum : Int,
    val studentNum : Int
)
