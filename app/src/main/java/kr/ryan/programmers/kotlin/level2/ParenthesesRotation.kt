package kr.ryan.programmers.kotlin.level2

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

/**
 * Programmers
 * Class: ParenthesesRotation
 * Created by pyg941007.
 * Created On 2024-04-29.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/76502
 */

fun main(){
    println(solutionas("[](){}"))
}

fun solutionas(s: String): Int {
    var answer: Int = 0

    val original: Queue<Char> = LinkedList()
    original.addAll(s.toList()) // 선입선출이기때문에 Queue 에 저장

    repeat((s.indices).count()) {
        if (checkCorrect(original.joinToString(""))) {
            answer++
        }
        val last = original.poll()!! // 가장먼저의 괄호를 빼주고
        original.add(last) // 맨뒤로 옮김
    }

    return answer
}

fun checkCorrect(parentheses: String): Boolean{

    val checkStack = Stack<Char>()

    for (i in parentheses.indices){
        val last = parentheses[i] // i 번째의 문자와 Stack 을 비교하기위함
        if (checkStack.isEmpty()){ // 비어있다면 추가
            checkStack.push(last)
        } else if (checkStack.peek() == '(' && last == ')'){ // 현재의 문자 ) 이전의 문자 ( 라면 맞는 괄호이기때문에 빼줌
            checkStack.pop()
        } else if (checkStack.peek() == '[' && last == ']'){ //..
            checkStack.pop()
        } else if (checkStack.peek() == '{' && last == '}'){ //..
            checkStack.pop()
        } else{
            checkStack.push(last)
        }
    }
    return checkStack.isEmpty() // 비어있다면 맞는 괄호 아니면 틀린 괄호
}