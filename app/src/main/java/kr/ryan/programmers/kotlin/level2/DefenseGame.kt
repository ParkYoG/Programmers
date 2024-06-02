package kr.ryan.programmers.kotlin.level2

import java.util.Collections
import java.util.PriorityQueue

/**
 * Programmers
 * Class: DefenseGame
 * Created by pyg941007.
 * Created On 2024-06-02.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/142085
 */

fun main(){

    println(solution(7, 3, intArrayOf(4, 2, 4, 5, 3, 3, 1)))
    println(solution(2, 4, intArrayOf(3, 3, 3, 3)))

}

fun solution(n: Int, k: Int, enemy: IntArray): Int {
    var answer = 0

    val enemyQueue: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())

    var invincibility = k
    var health = n

    for (index in enemy.indices){
        if (health < enemy[index] && invincibility == 0) {
            break
        }
        enemyQueue.offer(enemy[index])
        if (health < enemy[index]) {
            health += enemyQueue.poll() ?: 0
            invincibility--
        }
        health -= enemy[index]
        answer++
    }

    return answer
}