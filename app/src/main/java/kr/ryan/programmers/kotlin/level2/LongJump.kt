package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: LongJump
 * Created by pyg941007.
 * Created On 2024-04-26.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/12914
 */

fun main(){
    println(solutionaa(1))
    println(solutionaa(2))
    println(solutionaa(3))
    println(solutionaa(4))
}

/**
 *
 * 1
 *
 * 1 1
 * 2
 *
 * 1 1 1
 * 1 2
 * 2 1
 *
 * 1 1 1 1
 * 1 1 2
 * 1 2 1
 * 2 1 1
 * 2 2
 *
 * 1 1 1 1 1
 * 2 1 1 1
 * 1 2 1 1
 * 1 1 2 1
 * 1 1 1 2
 * 2 2 1
 * 2 1 2
 * 1 2 2
 *
 */
fun solutionaa(n: Int): Long {
    val answer = LongArray(n+2){0L}

    answer[0] = 0L
    answer[1] = 1L
    answer[2] = 2L
    for (i in 3..n){
        answer[i] = (answer[i-1] + answer[i-2]) % 1234567L
    }

    return answer[n]
}