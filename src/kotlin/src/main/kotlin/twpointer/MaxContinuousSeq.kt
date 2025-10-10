package twpointer

import java.util.*

/**
 * input:
 * 14 2
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * output:
 * 8
 */
fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val max = sc.nextInt()

    val arr = Array(n) { sc.nextInt() }

    var lt = 0
    var change = 0
    var answer = 0

    for (rt in 0 until n) {
        if (arr[rt] == 0) {
            change++
        }
        while (change > max) {
            if (arr[lt] == 0) {
                change--
            }
            lt++
        }
        answer = maxOf(answer, rt - lt + 1)
    }
    println(answer)
}