package com.lolmatch.util

import java.util.*
import java.util.function.Supplier

object StringUtils {
    private val RANDOM = Random()

    /**
     * 지정된 길이의 랜덤한 대문자, 소문자, 숫자형 문자를 생성
     * @param length 길이
     * @return 길이가 0이하인 경우 공백, 나머지 랜덤 대문자, 소문자, 숫자형 문자
     */
    fun randomStringGenerate(length: Int): String {
        return randomStrWithSupplier(length,::randomStr)
    }

    /**
     * 랜덤한 대문자, 소문자, 숫자형 문자를 생성
     * @return 대문자, 소문자, 숫자형 문자 1개
     */
    fun randomStr() = when (RANDOM.nextInt(3)) {
        0 -> randomLowerStr()
        1 -> randomCapitalStr()
        else -> randomNumberStr()
    }

    /**
     * 지정된 길이의 랜덤 대문자
     * @param length 길이
     * @return 길이가 0이하일경우 공백, 나머지 랜덤 대문자
     */
    fun randomCapitalStr(length: Int): String {
        return randomStrWithSupplier(length, ::randomCapitalStr)
    }

    /**
     * 랜덤 대문자
     * @return 랜덤 대문자 1개
     */
    fun randomCapitalStr(): String {
        return (RANDOM.nextInt(26) + 65).toChar().toString()
    }

    /**
     * 지정된 길이의 숫자형 문자
     * @param length 길이
     * @return 길이가 0이하일경우 공백, 나머지 랜덤 숫자
     */
    fun randomNumberStr(length: Int): String {
        return randomStrWithSupplier(length, ::randomNumberStr)
    }

    /**
     * 랜덤 숫자형 문자
     * @return 랜덤 숫자 1개
     */
    fun randomNumberStr(): String {
        return RANDOM.nextInt(10).toString()
    }

    /**
     * 지정된 길이의 랜덤 소문자
     * @param length 길이
     * @return 길이가 0이하일경우 공백, 나머지 랜덤 소문자
     */
    fun randomLowerStr(length: Int): String {
        return randomStrWithSupplier(length, ::randomLowerStr)
    }

    /**
     * 랜덤 소문자
     * @return 랜덤 소문자 1개
     */
    fun randomLowerStr(): String {
        return (RANDOM.nextInt(26) + 97).toChar().toString()
    }

    /**
     * 문자 제공 함수를 이용하여 지정된 길이의 랜덤 문자
     * @param length 길이
     * @param randomSup 문자제공 함수
     * @return 길이가 0이하일경우 공백, 나머지 문자제공함수에 맞는 랜덤문자
     */
    private fun randomStrWithSupplier(length: Int, randomSup: Supplier<String>): String {
        if (length <= 0) {
            return ""
        }
        val temp = StringBuilder()
        for (i in 0 until length) {
            temp.append(randomSup.get())
        }
        return temp.toString()
    }

    /**
     * LOLCW TAG 생성
     * 생성규칙 대문자 3자리 + 숫자 2자리
     * @return LOLCW TAG
     * @since 2021. 11. 22
     */
    val lolcwTag: String
        get() = randomCapitalStr(3) + randomNumberStr(2)
}