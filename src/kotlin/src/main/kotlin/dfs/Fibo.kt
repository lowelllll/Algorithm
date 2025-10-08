package dfs

import java.util.*

/**
 * 피보나치 (메모이제이션 적용)
 */
class Fibo(n: Int) {
    val fibo = IntArray(n+1)

    fun dfs(n: Int): Int {
        if (fibo[n] != 0) return fibo[n]
        if (n == 1) return 1
        if (n == 2) return 1
        fibo[n] = dfs(n - 1) + dfs(n - 2)
        return fibo[n]
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    val fibo = Fibo(n)
    for (i in 1 .. n) {
        print("${fibo.dfs(i)} ")
    }
}