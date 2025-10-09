package bfs

import java.util.*


private val MAX = 100_000

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()

    val queue = LinkedList<Int>()
    val ch = IntArray(MAX + 1)

    queue.add(n)
    ch[n] = 1

    var answer = 0
    while (queue.isNotEmpty()) {
        val candidates = mutableListOf<Int>()
        while(queue.isNotEmpty()) {
            candidates.add(queue.poll())
        }

        for (c in candidates) {
            if (c == m) {
                println(answer)
                return
            }
            if (c-1 in 0..MAX && ch[c-1] == 0) {
                ch[c-1] = 1
                queue.add(c-1)
            }
            if (c+1 in 0..MAX && ch[c+1] == 0) {
                ch[c+1] = 1
                queue.add(c+1)
            }
            if (c*2 in 0..MAX && ch[c*2] == 0) {
                ch[c*2] = 1
                queue.add(c*2)
            }
        }
        answer++
    }
}