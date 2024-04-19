package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: SliceArray
 * Created by pyg941007.
 * Created On 2024-04-19.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/87390
 */

fun main(){

    println(solution(3, 2, 5).contentToString())
    println(solution( 4, 3, 6).contentToString())

}

fun solution(n: Int, left: Long, right: Long): IntArray {

    val answer = arrayListOf<Int>()

    /**
     *
     * ex ) n = 3
     * matrix : 1 2 3
     *          2 2 3
     *          3 3 3
     *
     */

    for (index in left..right){
        val x = (index / n).toInt() + 1
        val y = (index % n).toInt() + 1

        answer.add(if (x > y) x else y)
    }

    return answer.toIntArray()
}