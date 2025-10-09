package bfs

import java.util.*


class Startlink(
    val f: Int,
    val g: Int,
    val u: Int,
    val d: Int
) {
    var pressCount = 0
    val ch = IntArray(f + 1)

    fun bfs(floor: Int) {
        var queue = LinkedList<Int>()
        queue.add(floor)
        ch[floor] = 1

        while(queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val cur = queue.poll()
                if (cur == g) {
                    println(pressCount)
                    return
                }
                if (cur + u in 1..f && ch[cur+u] == 0) {
                    ch[cur+u] = 1
                    // 큐에 넣을 때 방문 체크 해야함
                    // 큐에서 꺼내놓고 방문 체크하면 이미 방문한 곳이 큐에서 꺼내지지 않았을 때 중복 방문함
                    queue.add(cur + u)
                }
                if (d != 0 && cur - d in 1..f && ch[cur-d] == 0) {
                    ch[cur-d] = 1
                    queue.add(cur - d)
                }
            }
            pressCount++
        }
        println("use the stairs")
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val f = sc.nextInt()
    val s = sc.nextInt()
    val g = sc.nextInt()
    val u = sc.nextInt()
    val d  = sc.nextInt()

    if (s==g) {
        println(0)
        return
    }

    val startlink = Startlink(f,g,u,d)
    startlink.bfs(s)
}