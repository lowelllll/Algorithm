package dfs

import java.util.*
import kotlin.math.min


class Startlink(
    val f: Int,
    val g: Int,
    val u: Int,
    val d: Int
) {
    var answer = Int.MAX_VALUE
//    val ch = IntArray(f + 1)

    fun dfs(floor: Int, pressCount: Int) {
        if (floor == g) {
            answer = min(answer, pressCount)
            return
        }
        if (floor < 1) return
        if (floor > f) return
        if (pressCount > answer) return
//        if (ch[floor] == 1) return

//        ch[floor] = 1
        dfs(floor + u, pressCount + 1) // up
        dfs(floor - d, pressCount + 1) // up
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
    startlink.dfs(s, 0)

    if (startlink.answer == Int.MAX_VALUE) {
        println("use the stairs")
    } else {
        println(startlink.answer)
    }
}