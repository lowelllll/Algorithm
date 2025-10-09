package dfs

import java.util.*
import kotlin.collections.ArrayList

private class Dfs(private val graph: ArrayList<ArrayList<Int>>) {
    val ch = IntArray(graph.size + 1)

    fun dfs(node: Int) {
        if (ch[node] == 1) return
        ch[node] = 1
        print("$node ")

        for (next in graph[node]) {
            dfs(next)
        }
    }
}

private class Bfs(private val graph: ArrayList<ArrayList<Int>>) {
    val ch = IntArray(graph.size + 1)

    fun bfs(node: Int) {
        val queue = LinkedList<Int>()
        queue.add(node)
        ch[node] = 1

        while(!queue.isEmpty()) {
            val cur = queue.poll()
            print("$cur ")
            for (next in graph[cur]) {
                if (ch[next] == 0) {
                    queue.add(next)
                    ch[next] = 1
                }
            }
        }
    }
}

/**
 * https://www.acmicpc.net/problem/1260
 */
fun main() {
    val sc = Scanner(System.`in`)
    val n =  sc.nextInt() // 정점 개수
    val m = sc.nextInt() // 간선 개수
    val startNode = sc.nextInt()

    val graph = ArrayList<ArrayList<Int>>()

    for (i in 0 .. n) {
        graph.add(arrayListOf())
    }

    for (i in 0 until m) {
        val n1 = sc.nextInt()
        val n2 = sc.nextInt()

        graph[n1].add(n2)
        graph[n2].add(n1)
    }

    for (i in 1 .. n) {
        graph[i].sortBy { it } // 정렬
    }

    Dfs(graph).dfs(startNode)
    println()
    Bfs(graph).bfs(startNode)
}