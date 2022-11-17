package com.lolmatch.user.repository


interface UserCustomRepository {

    fun getUserByUserName(userName : String) : String
}