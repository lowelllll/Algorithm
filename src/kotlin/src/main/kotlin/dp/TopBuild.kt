package dp

import java.util.Scanner

private data class Brick(
    val width: Int,
    val height: Int,
    val weight: Int
)

/**
 * 가장 높은 탑 쌓기
 * input:
 * 5
 * 25 3 4
 * 4 4 6
 * 9 2 3
 * 16 2 5
 * 1 5 2
 *
 * output:
 * 10
 */
fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val bricks = Array(n) { Brick(sc.nextInt(), sc.nextInt(), sc.nextInt()) } // java array와 동일
    val dp = IntArray(n) { 0 }

    // 넓이로 정렬
    bricks.sortByDescending { it.width }
    dp[0] = bricks[0].height

    var answer = 0;
    for(i in 1 until n) {
        val brick = bricks[i]
        var maxBrickHeight = 0
        for(j in 0 until i) {
            val prevBrick = bricks[j]
            if (prevBrick.weight >= brick.weight && maxBrickHeight < dp[j]) {
                maxBrickHeight = dp[j]
            }
        }
        dp[i] = maxBrickHeight + brick.height
        answer = maxOf(answer, dp[i])
    }

    println(answer)
}