package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: Carpet
 * Created by pyg941007.
 * Created On 2024-04-17.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/42842#
 */

fun main(){
    println(solutions(10, 2).contentToString())
    println(solutions(8, 1).contentToString())
    println(solutions(24, 24).contentToString())
    println(solutions(4004, 999999).contentToString())
    println(solutions(3004, 2996).contentToString())
}

fun solutions(brown: Int, yellow: Int): IntArray {

    var width = 3
    var height = 3

    while (width >= height){

        val y = ( width - 2 ) * ( height - 2 )
        val b = width * height - y
        if (y == yellow && b == brown) break

        if (y < yellow && b== brown){
            width--
            height++
        }else{
            width++
        }
    }

    return intArrayOf(width, height)
}