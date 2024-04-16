package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: MagicElevator
 * Created by pyg941007.
 * Created On 2024-04-16.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/148653
 */

fun main(){
    println(solution(16))
    println(solution(2554))
    println(solution(9))
    println(solution(56))
    println(solution(46))
    println(solution(155))
    println(solution(55))
    println(solution(95))
    println(solution(45))
    println(solution(75))
    println(solution(555))
    println(solution(123456789))

}

fun solution(storey: Int): Int {
    var answer = 0

    var storeyTemp = storey
    while (storeyTemp > 0){
        val value = storeyTemp % 10 // 1의자리
        storeyTemp /= 10 // 나머지값

        if (value > 5){ // 더해주는것이 더효율적
            answer += 10 - value
            storeyTemp++ // 1의자리 추가
        }else if (value == 5){
            val temp = storeyTemp % 10 // 다음값의 1의자리
            if (temp >= 5){
                answer += 10 - value
                storeyTemp++ // 1의자리 추가
            }else{
                answer += value
            }
        }else{ // 빼주는게 더 효율적
            answer += value
        }
    }

    return answer
}