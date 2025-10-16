package search

import java.util.*

fun search(arr: IntArray, target: Int): Int {
    var start = 0
    var end = arr.size - 1

    while(start <= end) {
        var mid = (start + end) / 2
        when {
            arr[mid] == target -> return 1
            arr[mid] < target -> start = mid + 1
            else -> end = mid - 1
        }
    }
    return 0
}

fun main() {
    val sc = Scanner(System.`in`)

    val n =  sc.nextInt()
    val arr = IntArray(n) { sc.nextInt() }
    arr.sort()

    val m = sc.nextInt()
    val targets = IntArray(m) { sc.nextInt() }

    targets.forEach {
        println(search(arr, it))
    }
}