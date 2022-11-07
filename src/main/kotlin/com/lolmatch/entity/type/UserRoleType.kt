package com.lolmatch.entity.type

enum class UserRoleType(private val value: String) : EnumModel {
    ADMIN("ROLE_ADMIN"), USER("ROLE_USER");

    override fun getKey(): String {
        return name
    }

    override fun getValue(): String {
        return value
    }
}