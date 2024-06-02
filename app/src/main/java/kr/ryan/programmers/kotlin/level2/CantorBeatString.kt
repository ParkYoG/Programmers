package kr.ryan.programmers.kotlin.level2

import java.lang.Math.pow
import kotlin.math.pow

/**
 * Programmers
 * Class: CantorBeatString
 * Created by pyg941007.
 * Created On 2024-05-01.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/148652
 */

fun main(){
    println(solutiona(3,1,125))
}
/**
 *
 * 1 -> 0
 * 11011 -> 1
 * 1101111011000001101111011 -> 9
 * 110111101100000110111101111011110110000011011110110000011011110110000011011110111101111011000001101111011
 *
 */
fun solutiona(n: Int, l: Long, r: Long): Int {
    var answer = 0

    val sum = IntArray(5)
    sum[0] = 4.0.pow(n - 1).toInt()
    sum[1] = 4.0.pow(n - 1).toInt()
    sum[2] = 0
    sum[3] = 4.0.pow(n - 1).toInt()
    sum[4] = 4.0.pow(n - 1).toInt()



    return answer
}