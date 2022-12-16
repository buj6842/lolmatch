package com.lolmatch.user.dto

import com.lolmatch.user.enums.UserRoleType

class LoginResponseDTO  (
    val id : String?,
    val password : String?,
    val userType : UserRoleType?
){
}