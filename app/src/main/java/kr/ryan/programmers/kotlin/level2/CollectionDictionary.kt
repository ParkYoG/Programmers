package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: CollectionDictionary
 * Created by pyg10.
 * Created On 2024-04-17.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */

fun main(){
    println(solution("AAAAE"))
    println(solution("AAAE"))
    println(solution("I"))
    println(solution("EIO"))
}

val wordArray = arrayOf("A", "E", "I", "O", "U")

fun solution(word: String): Int {
    val dictionary = arrayListOf<String>() // 문자로 만들어지는 사전리스트
    for (i in wordArray.indices) {
        dfs(dictionary, wordArray[i]) // wordArray[i] 로 시작하는 모든값을 만듬
    }
    return dictionary.indexOf(word) + 1 // index 는 0부터 시작하기때문에 +1
}

/**
 *
 * A, AA, AAA, AAAA, AAAAA
 * AAAAE, AAAAI, AAAAO, AAAAU
 * AAAE, AAAEA ....
 *
 */

fun dfs(dictionary: ArrayList<String>,word: String){
    if (word.length > 5) return // 최대길이가 5이기때문에 5보다커지면 탈출
    if (!dictionary.contains(word)) dictionary.add(word) // 사전에 존재하지않으면 단어 추가

    for (i in wordArray.indices){
        dfs(dictionary, word+wordArray[i]) // 기존단어에 wordArray[i]를 추가한값으로 dfs 를 돌림
    }
}