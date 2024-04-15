package kr.ryan.programmers.kotlin.level2

import kotlin.math.max

/**
 * Programmers
 * Class: NumberCardDivision
 * Created by pyg941007.
 * Created On 2024-04-16.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/135807
 */

fun main(){
    println(solutions(intArrayOf(10, 17), intArrayOf(5, 20)))
    println(solutions(intArrayOf(10, 20), intArrayOf(5, 17)))
    println(solutions(intArrayOf(14, 35, 119), intArrayOf(18, 30, 102)))
}

fun solutions(arrayA: IntArray, arrayB: IntArray): Int {
    // 배열의 모든값의 최소공약수 구하기
    val gcdA = arrayA.fold(arrayA[0]){acc, i -> gcd(acc, i) }
    val gcdB = arrayB.fold(arrayB[0]){acc, i -> gcd(acc, i) }

    var a = 0
    var b = 0

    /**
     * 최소공약수가 1이라면 다 나누어지기때문에 제외
     * all 은 해당값이 모두 성립한다면 true 로 반환
     */

    if (gcdA != 1 && arrayB.all { it % gcdA != 0 }) a = gcdA
    if (gcdB != 1 && arrayA.all { it % gcdB != 0 }) b = gcdB

    return max(a, b) // a와 b중 큰값
}

fun gcd(a: Int, b: Int): Int{ // 최대공약수 구하기
    return if (b == 0) a
    else gcd(b, a % b)
}