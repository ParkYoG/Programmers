package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: ContinuousSubsequence
 * Created by pyg941007.
 * Created On 2024-04-12.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/131701
 */

fun main() {
    println(solution(intArrayOf(7, 9, 1, 1, 4)))
}

fun solution(elements: IntArray): Int {

    val removeDuplicationSum = mutableSetOf<Int>() // 선택된 수열의 합을 저장(중복을 제거하기위해서 Set을 사용)

    (1..elements.size).forEach { count -> // 1개선택부터 5개 선택까지
        (0..elements.lastIndex).forEach{ index ->
            var sum = 0
            (count until count + index).forEach{
                sum += elements[it % elements.size] // elements index가 0~4이기때문에 나머지를 이용하여 index를 구함
            }
            removeDuplicationSum.add(sum)
        }
    }

    return removeDuplicationSum.size
}