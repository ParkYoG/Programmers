package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: MinOrMax
 * Created by pyg941007.
 * Created On 2024-04-25.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/12939
 */

fun main(){
    println(solutiona("1 2 3 4"))
    println(solutiona("-1 -2 -3 -4"))
}

fun solutiona(s: String): String =
    s.split(" ").map { it.toInt() }.let { "${it.minOrNull()} ${it.max()}" }
