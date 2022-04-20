package com.example.lint

import java.util.regex.Pattern


const val lowerCase = "(.*[a-z].*)"
val dtoPattern = Pattern.compile("(.*dto)", Pattern.CASE_INSENSITIVE)!!
val entityPattern = Pattern.compile("(.*entity)", Pattern.CASE_INSENSITIVE)!!

/**
 * Name에 underBar(_)가 들어가는 경우 제거.
 *
 * Camel Case가 적용되어있지 않으면 적용.
 *
 * @param name 확인할 String
 * @return UnderBar가 제거되고 Camel Case를 만족하는 Name
 */
fun underBarChecker(name: String): String {
    val position = name.indexOf('_')
    val length = name.length - 1

    if (position == length || position == 0) {
        return name.replace("_", "")
    }

    val charCheck = name[position + 1]

    return if (Pattern.matches(lowerCase, charCheck.toString())) {
        name.replace("_$charCheck", "${charCheck.uppercaseChar()}")
    } else {
        name.replace("_", "")
    }
}

/**
 * 전달 받은 string과 index를 사용하여 해당 index를 대문자로 바꾸어 반환한다.
 *
 * @param text 원본 string
 * @param index 대문자로 변경할 index
 * @return 대문자로 변환 된 후의 string
 */
fun charUpperCase(text: String, index: Int) = text.replaceRange(index, index + 1, "${text[index].uppercaseChar()}")
fun changeDto(text: String, length: Int) = text.replaceRange(length - 3, length, "Dto")
fun changeEntity(text: String, length: Int) = text.replaceRange(length - 6, length, "Entity")