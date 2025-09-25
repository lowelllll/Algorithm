package bfs

import java.util.*

class Tomato(val n: Int, val m: Int, val box: Array<Array<Int>>) {
    var allGrow = true

    // 상하좌우 가능
    val dx = arrayOf(-1, 0, 1, 0)
    val dy = arrayOf(0, 1, 0, -1)
    val distance = Array(m) { Array(n) { 0 } }

    init {
        //  -1: 토마토 없음, 0: 익지 않은 토마토,, 1: 익은 토마토
        box.forEachIndexed { i, tomatos ->
            tomatos.forEachIndexed { j, tomato ->
                if (tomato == 0) { // 익지 않은 토마토
                    allGrow = false
                    distance[i][j] = -1
                }
            }
        }
    }


    fun bfs() {
        val queue = LinkedList<Pair<Int, Int>>()

        // 익은 토마토의 point queue에 넣기
        box.forEachIndexed { i, tomatos ->
            tomatos.forEachIndexed { j, tomato ->
                if (tomato == 1) {
                    queue.add(i to j)
                }
            }
        }

        while(queue.isNotEmpty()) {
            val (x, y) = queue.poll()
            for (i in 0 until dx.size) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (nx in 0 until m && ny in 0 until n && box[nx][ny] == 0) {
                    queue.add(nx to ny)
                    box[nx][ny] = 1
                    distance[nx][ny] = distance[x][y] + 1;
                }
            }
        }

    }
}

/**
 * 토마토
 *
 * input:
 * 6 4
 * 0 0 -1 0 0 0
 * 0 0 1 0 -1 0
 * 0 0 -1 0 0 0
 * 0 0 0 0 -1 1
 *
 * output:
 * 4
 */
fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()


    val box = Array(m) { Array(n) { sc.nextInt() } }
    val tomato = Tomato(n, m, box)
    tomato.bfs()

    var answer = 0;
    for(i in 0 until m) {
        for(j in 0 until n) {
            if (tomato.distance[i][j] == -1) { // 익지 않은 토마토가 있음
                println("-1")
                return
            }
            answer = maxOf(answer, tomato.distance[i][j])
        }
    }

    println(answer)

}