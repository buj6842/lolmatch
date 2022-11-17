package com.lolmatch.entity

import javax.persistence.*

@Entity
@Table(name = "ACCOUNT_INFO")
class AccountInfo: BaseEntity() {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @Column(name = "riot_user_key")
    var riotUserKey: String = ""

    @Column(name = "nickName")
    var nickName: String = ""

    @Column(name = "tier")
    var tier: String = ""

    @Column(name = "level")
    var level: Int = 0
}