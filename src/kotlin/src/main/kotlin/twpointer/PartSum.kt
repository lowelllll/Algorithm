package twpointer

import java.util.*

/**
 * input:
 * 10 15
 * 5 1 3 5 10 7 4 9 2 8
 *
 * output:
 * 2
 */
fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m  = sc.nextInt()

    val arr = IntArray(n) { sc.nextInt() }

//    arr.sort()

    var start = 0
    var sum = arr[start]

    var answer = Int.MAX_VALUE

    if (sum >= m) {
        println(1)
        return
    }

    for (end in 1 until n) {
        sum += arr[end]
        if (sum < m) {
            continue
        } else {
            while(sum >= m) {
                answer = minOf(answer, (end - start) + 1)
                sum -= arr[start]
                start++
                if (start == n) break
            }
        }
    }

    if (answer == Int.MAX_VALUE) {
        println(0)
    } else {
        println(answer)
    }
}