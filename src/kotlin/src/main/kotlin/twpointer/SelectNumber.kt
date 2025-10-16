package twpointer

import java.util.*

/**
 * input:
 * 3 3
 * 1
 * 5
 * 3
 *
 * output:
 * 4
 */
fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()

    val arr = Array(n) { sc.nextInt() }

    arr.sort()

    var end = 0
    var start = 0
    var answer = Int.MAX_VALUE
    while(end < n && start < n) {
        val diff = arr[end] - arr[start]
        if (diff < m) {
            end++
        } else {
            answer = minOf(answer, diff)
            start++
        }
    }
    println(answer)
}