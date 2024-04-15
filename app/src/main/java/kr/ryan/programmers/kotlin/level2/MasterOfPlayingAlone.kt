package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: MasterOfPlayingAlone
 * Created by pyg941007.
 * Created On 2024-04-15.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/131130
 */

fun main(){
    println(solutionss(intArrayOf(8,6,3,7,2,5,1,4)))
}

fun solutionss(cards: IntArray): Int {
    val visited = BooleanArray(100){false} // 카드가 100장이므로 방문 index 는 최대 100 방문한경우가 있다면 true
    val box = arrayListOf<IntArray>() // 박스에 들어있는 카드를 저장하는 리스트

    cards.indices.forEach { startIndex ->
        var lastIndex = startIndex // 인덱스 저장
        val cardBox = arrayListOf<Int>() // 박스에 넣을 카드리스트
        while (true){
            if (!visited[lastIndex]){ // 해당 index 에 방문한 적이 없다면
                cardBox.add(cards[lastIndex])
                visited[lastIndex] = true
                lastIndex = cards[lastIndex] - 1 // 인덱스는 0~99까지이기때문에 1을 빼줌
            }else{ // 방문한적이 있다면 지금까지의 카드리스트를 박스에 저장
                box.add(cardBox.toIntArray())
                break
            }
        }
    }

    val sortedBox = box.filter { it.isNotEmpty() }.sortedByDescending { it.size } // 빈경우를 제외하고, 크기순으로 정렬
    return if (sortedBox.size == 1 ) 0 else sortedBox[0].size * sortedBox[1].size // 박스가 한개인경우는 0 아닌 경우는 가장 큰 두개의 박스사이즈의 곱
}