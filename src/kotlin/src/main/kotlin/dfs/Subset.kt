package dfs

import java.util.*

class Subset(val arr: Array<Int>, val total: Int) {
    var answer = "NO"
    var flag = false

    fun dfs(level: Int, sum: Int) {
        if (flag) return
        if (level == arr.size) {
            if (total-sum == sum) {
                answer = "YES"
                flag = true
            }
        } else {
            dfs(level+1, sum + arr[level])
            dfs(level+1, sum)
        }
    }
}

/**
 * 합이 같은 부분집합
 * input:
 * 6
 * 1 3 5 6 7 10
 *
 * output:
 * YES
 *
 */
fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt();

    var total = 0;
    val arr = Array(n) {
        sc.nextInt().also { total += it }
    }

//    println(total)
    val s = Subset(arr, total)
    s.dfs(0, 0)
    println(s.answer)
}