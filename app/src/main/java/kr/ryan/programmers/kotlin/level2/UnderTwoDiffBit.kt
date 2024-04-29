package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: UnderTwoDiffBit
 * Created by pyg941007.
 * Created On 2024-04-29.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/77885
 */

fun main(){
    println(solution(longArrayOf(2, 5, 7)).contentToString())
}

fun solution(numbers: LongArray): LongArray {
    val answer = LongArray(numbers.size)

    numbers.forEachIndexed { index, number ->
        if (number % 2L == 0L){ // 짝수의경우 2진법으로 변경시 1의자리는 항상 0이기때문에 +1
            answer[index] = number + 1
        } else{
            answer[index] = calculator(number)
        }
    }

    return answer
}

fun calculator(number: Long): Long{
    val index = number.toString(2).let { num -> // 0의 위치찾기 ( 뒤에서의 위치를 찾는거기때문에 길이 - index ) 0부터시작하기때문에 -1을 해줌
        num.length - num.indexOfLast { it == '0' }
    } - 1

    var plusNumber = "1"
    var minusNumber = "1"

    for (i in 0 until index){
        plusNumber += "0"
    }

    for (i in 0 until index - 1){
        minusNumber += "0"
    }

    return number + plusNumber.toLong(2) - minusNumber.toLong(2)
}