package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: CuttingRollCake
 * Created by pyg941007.
 * Created On 2024-04-12.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/132265
 */

fun main() {
    println(solutions(intArrayOf(1, 2, 1, 3, 1, 4, 1, 2)))
}

fun solutions(topping: IntArray): Int {
    var answer = 0

    val frontArray = IntArray(topping.size) { 0 } // 앞에서부터 롤 케이크 개수
    val endArray = IntArray(topping.size) { 0 } // 뒤에서부터 롤 케이크 개수
    val front = hashSetOf<Int>() // 앞에서부터 롤 케이크 토핑 중복제거
    val end = hashSetOf<Int>() // 뒤에서부터 롤 케이크 토핑 중복제거

    for (index in 0..topping.lastIndex) {
        front.add(topping[index])
        frontArray[index] = front.size
    }

    for (index in topping.lastIndex downTo 0) {
        end.add(topping[index])
        endArray[index] = end.size
    }


    (1..frontArray.lastIndex).forEach {
        if (frontArray[it - 1] == endArray[it]) { // ex) 처음에서 자르면 [1] : [2 1 3 1 4 1 2] 를 비교해야하니 it - 1 과 it을 비교
            answer++
        }
    }

    return answer
}