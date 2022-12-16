package com.lolmatch.util.exception

/**
 * ServiceException
 * 화면에 뿌려줄 exception message를 저장
 */
open class ServiceException(val viewMessage: String) : Exception(viewMessage)