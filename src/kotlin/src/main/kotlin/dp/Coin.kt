package dp

import java.util.*


/**
 * 동전교환
 * input:
 * 3
 * 1 2 5
 * 15
 *
 * output:
 * 3
 */
fun main() {
    val sc = Scanner(System.`in`)
    val coinSize = sc.nextInt()
    val coins = Array(coinSize) { sc.next().toInt() }
    val amount = sc.nextInt()

    val dp = IntArray(amount+1) { Int.MAX_VALUE}
    dp[0] = 0

    for (i in 0 until coinSize) {
        for (j in coins[i]..amount) {
            dp[j] = minOf(dp[j], dp[j-coins[i]]+1)
        }
    }

    println(dp[amount])
}