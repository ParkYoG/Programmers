package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: RepeatConvertBit
 * Created by pyg941007.
 * Created On 2024-05-07.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */

fun main(){
    println(solutionr("110010101001").contentToString())
    println(solutionr("01110").contentToString())
    println(solutionr("1111111").contentToString())
}

fun solutionr(s: String): IntArray {

    var convert = s
    var count = 0
    var zeroCount = 0
    while (convert != "1"){
        zeroCount += convert.count { it == '0' } // 0개수 카운트
        convert = convert.replace("0", "") // 0을 삭제
        convert = convert.length.toString(2) // 길이를 이진변환
        count++
    }

    return intArrayOf(count, zeroCount)
}