package dfs

import java.util.*

/**
 * 간단한 조합 구하기
 *
 * input:
 * 4 2
 * output:
 * 1 2
 * 1 3
 * 1 4
 * 2 3
 * 2 4
 * 3 4
 */
class Combination(val n: Int, val m: Int) {
    val combi = Array(m) { 0 }

    fun dfs(level: Int, start: Int) {
        if (level == m) {
            for(c in combi) print("$c ")
            println()
        } else {
            for (i in start..n) {
                combi[level] = i
                dfs(level + 1, i + 1)
            }
        }
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()

    Combination(n, m).dfs(0, 1);

}