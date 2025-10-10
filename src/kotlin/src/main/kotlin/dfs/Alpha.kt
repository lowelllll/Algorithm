package dfs

import java.util.*

/**
 * 3 6
 * HFDFFB
 * AJHGDH
 * DGAGEH
 */

class Alpha(val r: Int, val c: Int, val arr: Array<CharArray>) {
    // 65 ~
    val alphaCh = IntArray(c) { 0 }
    val ch = Array(r) { IntArray(c) { 0 } }
    val aCode = 'A'.code

    val dx = arrayOf(-1, 0, 0, 1)
    val dy = arrayOf(0, -1, 1, 0)
    var answer = 0

    fun dfs(x: Int, y: Int, count: Int) { // 1로 시작

        for (i in 0 until dx.size) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0 until r && ny in 0 until c && alphaCh[arr[nx][ny].code % aCode] == 0) {
                alphaCh[arr[nx][ny].code % aCode] = 1
                dfs(nx, ny, count + 1)
                alphaCh[arr[nx][ny].code % aCode] = 0
            }
        }

        answer = maxOf(answer, count)
    }



}

fun main() {
    val sc = Scanner(System.`in`)
    val r = sc.nextInt()
    val c = sc.nextInt()

    sc.nextLine()
    val arr = Array(r) {
        sc.nextLine().toCharArray()
    }

    val a = Alpha(r, c, arr)
    a.dfs(0, 0, 1)
    println(a.answer)

}