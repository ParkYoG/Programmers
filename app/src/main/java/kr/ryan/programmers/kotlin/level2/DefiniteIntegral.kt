package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: DefiniteIntegral
 * Created by pyg941007.
 * Created On 2024-04-17.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/134239
 */

fun main(){
    println(solutions(5, arrayOf(intArrayOf(0,0), intArrayOf(0,-1), intArrayOf(2,-3), intArrayOf(3,-3))))
    println(solutions(3, arrayOf(intArrayOf(0,0), intArrayOf(1,-2), intArrayOf(3,-3))))
}

fun solutions(k: Int, ranges: Array<IntArray>): DoubleArray {
    val answer = DoubleArray(ranges.size)

    // 콜라츠추측을 통한 x,y 좌표값을 저장하기위한 리스트
    val matrix = arrayListOf<Pair<Int, Int>>() // x, y
    matrix.add(Pair(0, k))
    var count = 1 // x 좌표
    var standard = k
    while (standard > 1){
        if (standard % 2 == 0){
            standard /= 2
        }else{
            standard = standard * 3 + 1
        }
        matrix.add(Pair(count++, standard))
    }

    //각 부분의 넓이를 저장할 리스트
    val area = arrayListOf<Double>() // 0은 0~1의 사다리꼴 넓이
    for (i in 1..matrix.lastIndex){ // 사다리꼴의 넓이는 ((윗변 + 아랫변) * 높이 / 2)
        area.add((matrix[i-1].second.toDouble() + matrix[i].second.toDouble()) / 2)
    }

    for (i in 0..ranges.lastIndex){
        val startIndex = ranges[i][0] // 시작지점
        val endIndex = area.size + ranges[i][1] // -로 시작하기때문에 더해주면 끝나는지점

        if (endIndex < startIndex){ // 시작지점이 끝지점보다 크면 -1
            answer[i] = -1.0
        }else if (startIndex == endIndex){ // 동일하면 넓이는 존재하지 않기때문에 0
            answer[i] = 0.0
        }else{ // 해당지역의 합을 구해줌
            answer[i] = area.subList(startIndex, endIndex).sum()
        }
    }

    return answer
}