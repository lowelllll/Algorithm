package slidingwindow

import java.util.*

/**
 * 최대 매출
 * - sliding window O(N)
 * input:
 * 10 3
 * 12 15 11 20 25 10 20 19 13 15
 *
 * output:
 * 56
 */
fun main() {
    val sc = Scanner(System.`in`)
    val salesSize = sc.nextInt()
    val k = sc.nextInt()

    val sales = IntArray(salesSize) { sc.nextInt() }

    var answer = 0
    var sum = 0

    // 초기화
    for(i in 0 until k) {
        sum += sales[i]
    }
    answer = sum
    for (i in k until salesSize) {
        sum = sum + (sales[i] - sales[i-k])
        answer = maxOf(sum, answer)
    }

    println(answer)
}