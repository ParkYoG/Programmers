package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: SeesawPairing
 * Created by pyg941007.
 * Created On 2024-04-16.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/152996
 */

fun main() {
    println(solutionsss(intArrayOf(100, 180, 360, 100, 270)))
}

fun solutionsss(weights: IntArray): Long {
    var answer: Long = 0
    val sortedWeights = weights.sortedArray() // 무게순으로 정렬 (이분탐색을 위함)

    var prev = 0
    sortedWeights.forEachIndexed { index, weight ->
        if (index > 0 && sortedWeights[index] == sortedWeights[index - 1]) {
            prev--
            answer += prev
            return@forEachIndexed // continue 와 같은 역할
        }

        if (index == sortedWeights.lastIndex){
            return@forEachIndexed
        }

        // 정렬되어있기때문에 본인이 모든 값 중 가장 큰 경우의 인덱스를 찾아줌
        // ex) 50 100 150 200 의경우 100의인덱스는 1
        val standardIndex = findLeftStandard(sortedWeights, weight, index + 1)

        prev = 0
        for (i in standardIndex downTo index + 1) {
            // 같은 위치 || 4번 2번위치 || 3번 2번위치 || 4번 3번위치
            if (sortedWeights[index] == sortedWeights[i] || sortedWeights[index] * 2 == sortedWeights[i] || sortedWeights[index] * 3 == sortedWeights[i] * 2 || sortedWeights[index] * 4 == sortedWeights[i] * 3)
                prev++
        }
        answer+= prev
    }

    return answer
}

fun findLeftStandard(array: IntArray, target: Int, left: Int): Int {

    var low = left

    while (low < array.lastIndex) {
        val mid = low + (array.lastIndex - low) / 2
        if (array[mid] > target * 2) return mid
        else low = mid + 1
    }
    return low
}