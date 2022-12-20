package com.lolmatch.util

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object TimeUtils {
    const val SECONDS_AS_MILLISECONDS = 1000
    const val FULL_PATTERN = "yyyyMMddHHmmss"
    const val DAY_HOUR_MIN_PATTERN = "yyyyMMddHHmm"
    const val DAY_HOUR_PATTERN = "yyyyMMddHH"
    const val DAY_PATTERN = "yyyyMMdd"
    const val HOUR_PATTERN = "HH"
    const val MIN_PATTERN = "mm"
    const val minute = 60L
    const val hour = 60L * minute
    const val day = 24L * hour
    private val zoneId = ZoneId.systemDefault()

    /**
     * 현재 시간 반환
     * @return Long timeMillis
     */
    fun now() = System.currentTimeMillis()

    /**
     * 현재 시간과의 차이 반환
     * @param time 비교대상
     * @return 현재시간 - 비교대상
     */
    fun timeDiff(time: Long): Long {
        return System.currentTimeMillis() - time
    }

    /**
     * 시간 -> 년월일시 패턴
     * @param value ISO_LOCAL_DATE_TIME 시간
     * @return yyyyMMddHH
     */
    fun parseTodayDetail(value: String?): String {
        return DateTimeFormatter.ofPattern(DAY_HOUR_PATTERN).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(value))
    }

    /**
     * 시간 -> 년월일시분초 패턴
     * @param value ISO_OFFSET_DATE_TIME 시간
     * @return yyyyMMddHHmmss
     */
    fun parseTodayDetailOffset(value: String?): String {
        return DateTimeFormatter.ofPattern(FULL_PATTERN).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(value))
    }

    fun timeDetail(dayDif: Int = 0, hourDif: Int = 0, minDif: Int = 0, pattern: String? = FULL_PATTERN): String {
        return DateTimeFormatter.ofPattern(pattern).format(
            LocalDateTime.now()
                .plusDays(dayDif.toLong())
                .plusHours(hourDif.toLong())
                .plusMinutes(minDif.toLong())
        )
    }

    /**
     * 문자열의 연속적인 시간을 '년', '월', '일' 이 붙은 시간으로 변환
     * @param time 문자열 형태의 시간
     * @param oriPattern 원래 패턴
     * @param newPattern 변경할 패턴
     * @return 변환된 시간
     */
    fun convertTimeForKorean(time: String, oriPattern: String, newPattern: String): String {
        var convertedTime = " "
        if (newPattern.contains("yyyy") && oriPattern.contains("yyyy")) {
            val idx = oriPattern.indexOf("yyyy")
            convertedTime += time.substring(idx, idx + 4) + "년 "
        }
        if (newPattern.contains("MM") && oriPattern.contains("MM")) {
            val idx = oriPattern.indexOf("MM")
            convertedTime += time.substring(idx, idx + 2) + "월 "
        }
        if (newPattern.contains("dd") && oriPattern.contains("dd")) {
            val idx = oriPattern.indexOf("dd")
            convertedTime += time.substring(idx, idx + 2) + "일 "
        }
        if (newPattern.contains("HH") && oriPattern.contains("HH")) {
            val idx = oriPattern.indexOf("HH")
            convertedTime += time.substring(idx, idx + 2) + "시 "
        }
        if (newPattern.contains("mm") && oriPattern.contains("mm")) {
            val idx = oriPattern.indexOf("mm")
            convertedTime += time.substring(idx, idx + 2) + "분 "
        }
        if (newPattern.contains("ss") && oriPattern.contains("ss")) {
            val idx = oriPattern.indexOf("ss")
            convertedTime += time.substring(idx, idx + 2) + "초"
        }
        return convertedTime.trim { it <= ' ' }
    }

    fun getHourMin(): String = timeDetail(pattern = "HHmm")

    fun getHour(): String = timeDetail(pattern = HOUR_PATTERN)

    fun getMin(): String = timeDetail(pattern = MIN_PATTERN)
}