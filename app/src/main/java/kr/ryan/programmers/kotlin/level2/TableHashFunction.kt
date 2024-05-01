package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: TableHashFunction
 * Created by pyg10.
 * Created On 2024-05-01.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/147354
 */

fun main(){
    println(solution(arrayOf(intArrayOf(2,2,6), intArrayOf(1,5,10), intArrayOf(4,2,9), intArrayOf(3,8,3)), 2, 2, 3))
}

fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
    var answer = 0

    /**
     *
     * step 1
     * col 칼럼 기준으로 오름차순정렬, 값이 동일하다면 첫번째값을 비교하여 내림차순 정렬
     *
     */
    data.sortedWith { o1, o2 -> // 0부터가 아닌 1부터 시작이기때문에 1을 빼줌
        if (o1[col-1] == o2[col-1]) o2[0] - o1[0]
        else o1[col-1] - o2[col-1]
    }.let { sortedData ->
        /**
         *
         * step 2
         * S_i(정렬된 리스트의 i번째) 를 i로 나눈 나머지의 합을 구하기
         *
         * step 3
         * 해당 합을 xor 연산하기
         *
         */
        for (i in row_begin-1 until row_end){ // i 번째라는 의미는 0부터가아닌 1부터이기떄문에 1을 빼줌
            answer = answer xor sortedData[i].sumOf { it % (i + 1) } // i 번째로 나누는 것, 따라서 1을 더해준값으로 계산하여야함.
        }
    }

    return answer
}