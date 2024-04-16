package kr.ryan.programmers.kotlin.level2

import kotlin.math.sqrt

/**
 * Programmers
 * Class: ConvertKDecimal
 * Created by pyg9410.
 * Created On 2024-04-17.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */

fun main(){
    println(solution(437674, 3))
    println(solution(110011, 10))
    println(solution(10000, 10))
    println(solution(797161, 3))
}

fun solution(n: Int, k: Int): Int {
    var answer: Int = 0

    val primeNumberCheck = arrayListOf<String>()

    // K 진법으로 변환 후 0을 제거하고 1이아닌경우와 비어있지않은경우만 체크함
    primeNumberCheck.addAll(n.toString(k).split("0").filter { it != "1" && it.isNotEmpty() })

    val correctList = arrayListOf<Long>()
    primeNumberCheck.forEach {
        val convert = it.toLong(10) // 4번째의경우 Int 로 변환하게되면 오버플로우가 발생 따라서 Long 으로 형변환
        if (correctList.contains(convert)){ // 이미 값이존재한다면 소수체크를하지않고 넘어감
            answer++
        }else{
            if (isPrime(convert)){
                correctList.add(convert)
                answer++
            }
        }
    }

    return answer
}

fun isPrime(k: Long): Boolean{
    if (k <= 1) return false
    return (2..sqrt(k.toDouble()).toInt()).none{ k % it == 0L }
}