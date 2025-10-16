package search

import java.util.*

/**
 * input:
 * 3 10
 * 1 2 3 4 5 6 7 8 9 10
 *
 * output:
 * 8
 */
fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt() // 조카 수
    val m = sc.nextInt() // 과자 수
    var max = 0
    val snacks = IntArray(m) {
        val input = sc.nextInt()
        max = maxOf(max, input)
        input
    }

//    var i = 1
//    val arr = IntArray(n) { i++ }
    var start = 1
    var end = max
    var answer = 0

    while(start <= end) {
        val mid = (start + end) / 2

        val shareCount = snacks.sumOf { len ->
            if (len < mid) {
                0
            } else {
                len / mid
            }
        }
        if (shareCount >= n) {
            answer = mid
            start = mid + 1
        } else {
            end = mid - 1
        }
    }

    println(answer)
}