package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: SearchRank
 * Created by pyg10.
 * Created On 2024-06-03.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/72412
 */

fun main() {

    println(
        solution(
            arrayOf(
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
            ),
            arrayOf(
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
            )
        ).contentToString()
    )

}

fun solution(info: Array<String>, query: Array<String>): IntArray {
    val answer = IntArray(query.size)

    val schedule = mutableMapOf<String, MutableList<Int>>()

    info.forEach {
        schedule.dfs("", 0, it.split(" ").toTypedArray())
    }

    schedule.values.forEach { it.sort() } // 각각의 리스트들을 오름차순으로 정렬

    query.forEachIndexed {index, s ->
        val splitQuery = s.replace(" and ","").split(" ")
        answer[index] = schedule.search(splitQuery[0], splitQuery[1].toInt())
    }

    return answer
}

fun MutableMap<String, MutableList<Int>>.search(key: String, score: Int) : Int{
    if (!this.containsKey(key)) return 0 // 키값이 존재하지않는다면

    var left = 0
    var right = this[key]!!.size - 1

    while (left <= right){
        val mid = (left + right) / 2
        if (this[key]!![mid] < score){
            left = mid + 1
        }else{
            right = mid - 1
        }
    }

    return this[key]!!.size - left
}

fun MutableMap<String, MutableList<Int>>.dfs(key: String, depth: Int, row: Array<String>){

    if (depth == 4){
        if (this.containsKey(key)) this[key]!!.add(row[depth].toInt())
        else this[key] = mutableListOf(row[depth].toInt())
        return
    }

    //다음조건이 -인경우
    dfs("$key-", depth + 1, row)
    //다음조건이 존재하는경우
    dfs("$key${row[depth]}", depth + 1, row)
}
