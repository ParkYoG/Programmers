package kr.ryan.programmers.kotlin.level2

import java.util.*

/**
 * Programmers
 * Class: MazeEscape
 * Created by pyg941007.
 * Created On 2024-05-06.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/159993#
 */

fun main(){

    println(solutions(arrayOf("SLEOX", "XXXXO", "OOOOO", "OXXXX", "OOOOO")))

}

val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

data class Matrix(val row: Int, val col: Int, var move: Int = 0)

fun solutions(maps: Array<String>): Int {
    var move = -1

    val convertMap = maps.map { it.map { value -> value }.toCharArray() }.toTypedArray()

    var start = Matrix(0, 0)
    var lever = Matrix(0, 0)
    var exit = Matrix(0, 0)

    for (row in convertMap.indices){
        for (col in convertMap[0].indices){
            if (convertMap[row][col] == 'S'){
                start = Matrix(row, col) // 시작지점
            }else if (convertMap[row][col] == 'L'){
                lever = Matrix(row, col) // 레버지점
            }else if (convertMap[row][col] == 'E'){
                exit = Matrix(row, col) // 탈출치점
            }
        }
    }


    val startToLever = mazeBfs(convertMap, start, lever)
    if (startToLever != -1){ // 레버로 갈수없다면 -1을 리턴
        val leverToExit = mazeBfs(convertMap, lever, exit)
        if (leverToExit != -1){ // 레버로는 갈수있지만 출구로 갈수없다면 -1을 리턴
            move = startToLever + leverToExit // 둘다갈수있다면 둘의 합을 리턴
        }
    }

    return move
}

fun mazeBfs(maps: Array<CharArray>, start: Matrix, dest: Matrix): Int{
    val queue : Queue<Matrix> = LinkedList()
    queue.add(start) // queue에 시작위치를 추가
    val visited = Array(maps.size){BooleanArray(maps[0].size){false}}
    visited[start.row][start.col] = true // 현재위치 방문

    while (queue.isNotEmpty()){
        val current = queue.poll()!!

        if (maps[current.row][current.col] == maps[dest.row][dest.col]){ // 목표위치에 도달했다면 이동한시간을 리턴
            return current.move
        }

        for (i in 0 until 4){
            //4가지 경우
            val nx = current.row + dx[i] // 좌우이동
            val ny = current.col + dy[i] // 상하이동

            // 맵밖으로 탈출하거나 X를 만나거나 이미방문한적이있다면 continue
            if (nx < 0 || nx > maps.size - 1 || ny < 0 || ny > maps[0].size - 1 || maps[nx][ny] == 'X' || visited[nx][ny]) continue

            visited[nx][ny] = true
            queue.add(Matrix(nx, ny, current.move+1))

        }
    }

    return -1
}