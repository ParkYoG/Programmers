package kr.ryan.programmers.kotlin.level2

import java.util.LinkedList
import java.util.Queue

/**
 * Programmers
 * Class: Process
 * Created by pyg941007.
 * Created On 2024-06-07.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/42587
 */

fun main(){

    println(solution(intArrayOf(1, 1, 2, 3, 1, 2), 0))

}

fun solution(priorities: IntArray, location: Int): Int {
    var answer = 0

    val indexingQueue: Queue<Int> = LinkedList<Int>().apply {
        for (index in priorities.indices){
            offer(index)
        }
    }

    val priorityQueue: Queue<Int> = LinkedList<Int>().apply {
        for (index in priorities.indices){
            offer(priorities[index])
        }
    }

    while (priorityQueue.isNotEmpty()){

        if (priorityQueue.maxOrNull() != priorityQueue.peek()){
            priorityQueue.offer(priorityQueue.poll())
            indexingQueue.offer(indexingQueue.poll())
        }else{
            answer++
            if (location == indexingQueue.peek()){
                break
            }
            indexingQueue.poll()
            priorityQueue.poll()
        }
    }

    return answer
}