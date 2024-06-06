package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: BiggestNumber
 * Created by pyg941007.
 * Created On 2024-06-07.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */

fun main(){

    println(solutionNum(intArrayOf(6, 10, 2)))
    println(solutionNum(intArrayOf(3, 30, 34, 5, 9)))
}

fun solutionNum(numbers: IntArray): String {
    /**
     * 사전적 정렬
     * 앞뒤/뒤앞 합친것을 비교해서 더 큰순으로 정렬 ex) 610 106 비교 102 210 비교 6 2 10
     * 0으로 시작한다면 값은 0이라는 의미
     */
    return numbers.map { it.toString() }.sortedWith{o1, o2 -> (o2 + o1).compareTo(o1 + o2)}.joinToString("").takeIf { !it.startsWith('0') } ?: "0"
}