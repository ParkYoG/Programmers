package kr.ryan.programmers.kotlin.level2

import kotlin.math.max

/**
 * Programmers
 * Class: Fatigue
 * Created by pyg941007.
 * Created On 2024-04-17.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */

fun main(){
    println(solution(80, arrayOf(intArrayOf(80, 20), intArrayOf(50, 40), intArrayOf(30, 10))))
}


fun solution(k: Int, dungeons: Array<IntArray>): Int {
    val visited = BooleanArray(dungeons.size){false} // 방문여부
    return dfs(dungeons, visited, k, 0, 0)
}

//순열을 이용
fun dfs(dungeons: Array<IntArray>, visited: BooleanArray, health: Int, maxCount: Int, count: Int): Int{
    var m = maxCount
    for ((index, dungeon) in dungeons.withIndex()){
        if (!visited[index] && health >= dungeon[0]){
            visited[index] = true
            m = dfs(dungeons, visited, health - dungeon[1], m, count + 1)
            visited[index] = false
        }
    }
    return max(m, count)
}