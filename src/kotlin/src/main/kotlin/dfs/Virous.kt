package dfs

import java.util.*
import kotlin.collections.ArrayList


class Virous(val graph: ArrayList<ArrayList<Int>>) {
    val ch = IntArray(graph.size + 1)
    var answer = 0

    fun dfs(computer: Int) {
        if (ch[computer] == 1) return
        ch[computer] = 1
        if (computer != 1) { // 1번 컴퓨터는 제외
            answer++
        }

        for (next in graph[computer]) {
            dfs(next)
        }
    }
}

/**
 * https://www.acmicpc.net/problem/2606
 */
fun main() {
    val graph = ArrayList<ArrayList<Int>>()
    val sc = Scanner(System.`in`)

    val n = sc.nextInt() // 컴퓨터 수
    val m = sc.nextInt()

    for (i in 0 .. n) {
        graph.add(arrayListOf())
    }

    for (i in 0 until m) {
        val n1 = sc.nextInt()
        val n2 = sc.nextInt()

        graph[n1].add(n2)
        graph[n2].add(n1)
    }

    val v = Virous(graph)

    v.dfs(1)
    println(v.answer)
}