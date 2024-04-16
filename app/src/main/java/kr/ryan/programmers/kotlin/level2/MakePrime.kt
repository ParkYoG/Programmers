package kr.ryan.programmers.kotlin.level2

import kotlin.math.sqrt

/**
 * Programmers
 * Class: MakePrime
 * Created by pyg941007.
 * Created On 2024-04-17.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */


fun main(){

    //println(solutions("17"))
    println(solutions("011"))

}

val result = arrayListOf<Int>() // 순열 결과저장리스트

fun solutions(numbers: String): Int {
    var answer = 0
    val element = arrayListOf<Char>()
    val visited = BooleanArray(numbers.length){false}
    for (i in 1 .. numbers.length) {
        permutation(element, numbers, visited, i)
    }
    result.forEach {
        if (isPrime(it)){
            answer++
        }
    }
    return answer
}

fun permutation(element: ArrayList<Char>, number: String, visited: BooleanArray, count: Int){

    if (count == 0){ // 다 뽑았다면
        val convert = element.joinToString("").toInt() // char 리스트를 String 으로 변환한 후 int 로 변환
        if (!result.contains(convert)) result.add(convert) // 결과값에 해당값이 없다면 추가
        return
    }

    (number.indices).forEach {
        if (!visited[it]) { // 방문한적이없다면
            visited[it] = true
            element.add(number[it]) // 추가
            permutation(element, number,visited, count - 1) // 뽑았으니 count -1을 해줌
            element.removeLast() // 가장 뒤의값 제거
            visited[it] = false
        }
    }

}

fun isPrime(k: Int): Boolean{
    if (k <= 1) return false
    return (2..sqrt(k.toDouble()).toInt()).none{ k % it == 0}
}