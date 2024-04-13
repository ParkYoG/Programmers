package kr.ryan.programmers.kotlin.level2

/**
 * Programmers
 * Class: DiscountOffer
 * Created by pyg941007.
 * Created On 2024-04-13.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/131127
 */

fun main() {

    println(
        solution(
            arrayOf("banana", "apple", "rice", "pork", "pot"),
            intArrayOf(3, 2, 2, 2, 1),
            arrayOf(
                "chicken",
                "apple",
                "apple",
                "banana",
                "rice",
                "apple",
                "pork",
                "banana",
                "pork",
                "rice",
                "pot",
                "banana",
                "apple",
                "banana"
            )
        )
    )

}

fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
    var answer = 0

    val wantCount = hashMapOf<String, Int>() // 원하는물품, 개수

    want.indices.forEach { index ->
        wantCount[want[index]] = number[index]
    }

    discount.indices.forEach { index ->
        val discountMap = hashMapOf<String, Int>()
        for (i in index until index + 10) { // 시작일로부터 10일까지
            if (i > discount.lastIndex) { // 시작일로부터 10일이 최대일수보다 크다면
                break
            }
            discountMap[discount[i]] = discountMap.getOrDefault(discount[i], 0).plus(1) // 이미 존재한다면 그값에서 + 1 없다면 0에서 + 1
        }
        if (checkDiscount(wantCount, discountMap)){ // 원하는 물품과 개수만큼 다 판다면
            answer++
        }
    }

    return answer
}

fun checkDiscount(want: HashMap<String, Int>, discount: HashMap<String, Int>): Boolean {
    var correct = true
    run {
        want.keys.forEach { // 원하는 물품의 키값
            val count = discount.getOrDefault(it, 0) // 할인물품의 값(없는 경우도 있기때문에 NotNull 을 이용하지않고 getOrDefault 를 이용)
            if (count == 0 || want[it]!! > count){ // 0이라면 할인물품에 존재하지않으니 false | 원하는 물품의 양이 더 크다면 가입하지않으니 false
                correct = false
                return@run //forEach 에서 탈출하기위해서 run 스코프를 이용
            }
        }
    }
    return correct
}