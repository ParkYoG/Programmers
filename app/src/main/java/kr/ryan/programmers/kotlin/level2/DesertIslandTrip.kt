package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: DesertIslandTrip
 * Created by pyg10.
 * Created On 2024-05-06.
 * Description:
 */

fun main(){

    println(solution(arrayOf("X591X","X1X5X","X231X","1XXX1")).contentToString())

}

val sumList = arrayListOf<Int>()

fun solution(maps: Array<String>): IntArray {

    // X는 -1 나머지는 그냥값으로 변환
    val convertMap = maps.map { it.map{ value -> if (value == 'X') -1 else value.digitToInt()}.toIntArray()  }.toTypedArray()
    // 방문리스트
    val visited = Array(maps.size){BooleanArray(maps[0].length){false} }

    convertMap.forEachIndexed { row, map ->
        map.forEachIndexed { col, value ->
            if (value != -1 && !visited[row][col]){ // X가 아니고 방문한적이없다면 시작
                sumList.add(0) // 섬이만들어졌으니 답 리스트에 0을 추가
                dfs(visited, row, col, convertMap)
            }
        }
    }

    return if (sumList.isNotEmpty()) sumList.sorted().toIntArray() else intArrayOf(-1)
}


fun dfs(visited: Array<BooleanArray>, row: Int, col: Int, map: Array<IntArray>){

    if (row < 0 || row > map.size - 1 || col < 0 || col > map[0].size - 1){ // 맵 밖으로 벗어나면 탈출
        return
    }

    if (visited[row][col] || map[row][col] == -1){ // 이미 방문했거나 X에 도달하는경우 탈출
        return
    }

    visited[row][col] = true

    sumList[sumList.lastIndex] = sumList.last() + map[row][col] // 누적값 추가

    dfs(visited, row + 1, col, map) // 위로이동
    dfs(visited, row - 1, col, map) // 아래로이동
    dfs(visited, row, col + 1, map) // 오른쪽으로이동
    dfs(visited, row, col - 1, map) // 왼쪽으로이동

}