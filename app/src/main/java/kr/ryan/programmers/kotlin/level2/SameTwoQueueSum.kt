package kr.ryan.programmers.kotlin.level2

import java.util.LinkedList
import java.util.Queue

/**
 * Programmers
 * Class: SameTwoQueueSum
 * Created by pyg941007.
 * Created On 2024-04-14.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/118667
 */

fun main(){
    println(solution(intArrayOf(3, 2, 7, 2), intArrayOf(4, 6, 5, 1)))
    println(solution(intArrayOf(1, 2, 1, 2), intArrayOf(1, 10, 1, 2)))
    println(solution(intArrayOf(1, 1), intArrayOf(1, 5)))
    println(solution(intArrayOf(1, 1, 1, 1), intArrayOf(1, 1, 7, 1)))
}

fun solution(queue1: IntArray, queue2: IntArray): Int {
    var answer = 0

    val firstQueue: Queue<Int> = LinkedList()
    val secondQueue: Queue<Int> = LinkedList()

    firstQueue.addAll(queue1.toList())
    secondQueue.addAll(queue2.toList())

    // while 문 안에서 sum 을 이용하게되면 타임아웃이 발생하기 때문에 변수에 저장
    var firstSum = firstQueue.sum().toLong()
    var secondSum = secondQueue.sum().toLong()

    while (true){
        if (answer > (firstQueue.size + secondQueue.size)*2 ) { // 두번씩 주고받은경우에는 만들 수 없음.
            answer = -1
            break
        }

        if (firstSum == secondSum){ // 두 queue가 같다면 탈출
            break
        }else if(firstSum > secondSum){ // 첫번째 queue가 더 크다면 처음값을 빼주고 두번째 queue에 처음값을 넘겨줌
            firstSum -= firstQueue.peek() ?: 0
            secondSum += firstQueue.peek() ?: 0
            secondQueue.add(firstQueue.poll())
        }else{
            firstSum += secondQueue.peek() ?: 0
            secondSum -= secondQueue.peek() ?: 0
            firstQueue.add(secondQueue.poll())
        }
        answer++
    }

    return answer
}