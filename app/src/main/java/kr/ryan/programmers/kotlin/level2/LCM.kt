package kr.ryan.programmers.kotlin.level2

import java.util.Stack

/**
 * Programmers
 * Class: LCM
 * Created by pyg941007.
 * Created On 2024-04-25.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/12953
 */

fun main(){

    solutionL(intArrayOf(2,6,8,14))

}

fun solutionL(arr: IntArray): Int {
    var answer = -1

    val stack = Stack<Int>() // 앞에서부터 계산하기떄문에 스택을 이용
    arr.forEach {
        stack.push(it)
    }

    if (stack.size == 1){ // arr size 가 1~15기 때문에 1개만있는경우는 계산할 수가없음
        return stack.pop()
    }

    while (stack.isNotEmpty()){
        if (answer == -1){ // 최초실행시 값이없기때문에 값을 지정해줌
            answer = stack.pop()
        }
        val second = stack.pop() // 두번재값
        answer = lcm(answer, second) // 이전 최소공배수와 다음수와의 최소공배수
    }

    return answer
}

fun lcm(a: Int, b: Int) = (a * b) / gcd(a, b)

//fun gcd(a: Int, b: Int): Int{ // 최대공약수 구하기
//    return if (b == 0) a
//    else gcd(b, a % b)
//}