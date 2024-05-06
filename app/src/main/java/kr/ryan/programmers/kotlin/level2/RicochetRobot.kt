package kr.ryan.programmers.kotlin.level2

import java.util.LinkedList
import java.util.Queue

/**
 * Programmers
 * Class: RicochetRobot
 * Created by pyg941007.
 * Created On 2024-05-06.
 * Description:https://school.programmers.co.kr/learn/courses/30/lessons/169199
 */

fun main(){
    println(solutionr(arrayOf("...D..R", ".D.G...", "....D.D", "D....D.", "..D....")))
}

val ricochetDx = intArrayOf(1, -1, 0, 0)
val ricochetDy = intArrayOf(0, 0, -1, 1)

data class Robot(val x: Int, val y: Int, var move: Int = 0)

fun solutionr(board: Array<String>): Int {

    val convertBoard = board.map { it.map { value -> value }.toCharArray() }.toTypedArray()

    var start = Robot(0, 0)
    var dest = Robot(0, 0)

    for (row in convertBoard.indices){
        for (col in convertBoard[0].indices){
            if (convertBoard[row][col] == 'R'){ // 시작좌표
                start = Robot(row, col)
            }else if (convertBoard[row][col] == 'G'){ // 목표좌표
                dest = Robot(row, col)
            }
        }
    }

    return ricochetBFS(convertBoard, start, dest)
}

fun ricochetBFS(board: Array<CharArray>, start: Robot, dest: Robot): Int{
    val queue: Queue<Robot> = LinkedList()
    queue.add(start)

    val visited = Array(board.size){BooleanArray(board[0].size){false}}
    visited[start.x][start.y] = true

    while (queue.isNotEmpty()){
        val current = queue.poll()!!

        if(dest.x == current.x && dest.y == current.y){ // 현재좌표와 목표좌표가 일치하면 탈출
            return current.move
        }

        for (i in 0 until 4){

            var dx = current.x
            var dy = current.y

            while(true) {
                // 범위를 벗어나거나 장애물을 만나면 탈출
                if (dx < 0 || dx > board.size - 1 || dy < 0 || dy > board[0].size - 1 || board[dx][dy] == 'D'){
                    break
                }

                dx += ricochetDx[i]
                dy += ricochetDy[i]
            }

            //범위를 벗어나거나 장애물을 만나기 직전의 상태
            dx -= ricochetDx[i]
            dy -= ricochetDy[i]

            // 방문한 장소이거나 같은 위치의 경우 스킵
            if ((dx == current.x && dy == current.y) || visited[dx][dy]) continue

            visited[dx][dy] = true
            queue.add(Robot(dx, dy, current.move + 1))
        }

    }

    return -1
}