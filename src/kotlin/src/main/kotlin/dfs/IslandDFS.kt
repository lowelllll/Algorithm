package dfs

import java.util.*
/**
 * 섬 개수 찾기
 *
 * input:
 * 7
 * 1 1 0 0 0 1 0
 * 0 1 1 0 1 1 0
 * 0 1 0 0 0 0 0
 * 0 0 0 1 0 1 1
 * 1 1 0 1 1 0 0
 * 1 0 0 0 1 0 0
 * 1 0 1 0 1 0 0
 *
 * output:
 * 5
 */


class Island(val n: Int, val map: Array<Array<Int>>) {
    // 상하좌우대각선 이동 가능
//    0,0 0,1 0,2
//    1,0 1,1 1,2
//    2,0 0,1 2,2
    val dx = arrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
    val dy = arrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

    fun dfs(x: Int, y: Int) {
        map[x][y] = 0
        for (i in 0 until dx.size) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (nextX in 0 until n && nextY in 0 until n && map[nextX][nextY] == 1) {
                dfs(nextX, nextY)
            }
        }

    }
}
fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val map = Array(n) { Array(n) { sc.nextInt() } }

    val island = Island(n, map)
    var answer = 0
    for (x in 0 until n) {
        for (y in 0 until n) {
            if (map[x][y] == 1) {
                answer++
                island.dfs(x, y)
            }
        }
    }

    println(answer)
}