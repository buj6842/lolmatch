package com.lolmatch.entity

import jakarta.persistence.*

@Entity
@Table(name = "USER")
class User: BaseEntity() {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @Column(name = "user_id")
    var userId: String = ""

    @Column(name = "password")
    var password: String = ""

    @Column(name = "oldPassword")
    var oldPassword: String = ""

    @Column(name = "phone")
    var phone: String = ""

    @Column(name = "email")
    var email: String = ""

    @Column(name = "prefer_position1")
    var preferPosition1: String = ""

    @Column(name = "prefer_position2")
    var preferPosition2: String = ""

    @OneToOne
    @JoinColumn(name = "account_info_id")
    var accountInfo: AccountInfo? = null

}
