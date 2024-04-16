package kr.ryan.programmers.kotlin.level2

import java.util.*

/**
 * Programmers
 * Class: DeliveryBox
 * Created by pyg941007.
 * Created On 2024-04-16.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/131704
 */

fun main() {

    println(solutionssss(order = intArrayOf(4, 3, 1, 2, 5)))
    println(solutionssss(order = intArrayOf(5, 4, 3, 2, 1)))
    println(solutionssss(order = intArrayOf(3, 5, 4, 2, 1)))

}

fun solutionssss(order: IntArray): Int {
    var answer: Int = 0

    val mainContainer = LinkedList<Int>() // 메인컨테이너는 선입선출 따라서 Queue
    val subContainer = Stack<Int>() // 서브컨테이너는 선입후출 따라서 Stack

    (1..order.size).forEach { // 메인컨테이너는 1 ~ order 의 사이즈만큼 순차적으로 존재
        mainContainer.add(it)
    }

    for (boxNum in order) { // 주문받은 박스번호
        if (subContainer.isNotEmpty() && subContainer.peek() == boxNum) { // 서브컨테이너가 비어있지않고 가장뒤에있는 번호가 주문번호와 동일하면
            subContainer.pop()
            answer++
        } else {
            if (mainContainer.isNotEmpty()) { // 메인컨테이너가 비어있지않다면
                while (mainContainer.isNotEmpty()) {
                    if (mainContainer.peek() == boxNum) { // 메인컨테이너의 앞의 값이 주문번호와 동일하다면
                        mainContainer.poll()
                        answer++
                        break
                    } else {
                        subContainer.push(mainContainer.poll()) // 그렇지않으면 서브컨테이너에 추가
                    }
                }
            } else { // 메인컨테이너도 비어있다면 더이상 트럭에 실을수가 없음
                break
            }
        }
    }

    return answer
}