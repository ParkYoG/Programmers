package kr.ryan.programmers.kotlin.level2

import java.util.LinkedList
import java.util.Queue

/**
 * Programmers
 * Class: FunctionDevelopment
 * Created by pyg941007.
 * Created On 2024-06-10.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/42586?language=kotlin
 */

fun main(){

    println(solutionFunction(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)).contentToString())
    println(solutionFunction(intArrayOf(95, 90, 99, 99, 80, 99), intArrayOf(1, 1, 1, 1, 1, 1)).contentToString())

}

fun solutionFunction(progresses: IntArray, speeds: IntArray): IntArray {
    val answer = arrayListOf<Int>()

    val development : Queue<Int> = LinkedList<Int>().apply {
        progresses.forEach {
            offer(it)
        }
    }
    var index = 0
    while (development.isNotEmpty()){
        var dayCount = 0
        while (development.peek()!! + (speeds[index] * dayCount) < 100){
            dayCount++
        }

        var count = 0
        while (true){
            val currentDevelopment = development.peek() ?: break
            if (currentDevelopment + (speeds[index] * dayCount) < 100){
                break
            }else{
                development.poll()
            }
            count++
            index++
        }
        answer.add(count)
    }

    return answer.toIntArray()
}