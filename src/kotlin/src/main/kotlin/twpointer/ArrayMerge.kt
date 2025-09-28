package twpointer

import java.util.*

/**
 * 두 배열 합치기
 * input:
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 *
 * output:
 * 1 2 3 3 5 6 7 9
 */
fun main() {
    val sc = Scanner(System.`in`)
    val arr1Size = sc.nextInt()
    val arr1 = Array(arr1Size) { sc.nextInt() }

    val arr2Size = sc.nextInt()
    val arr2 = Array(arr2Size) { sc.nextInt() }

    var p1 = 0
    var p2 = 0

    var result = Array(arr1Size + arr2Size) { 0 }

    for (i in 0 until result.size) {
        if (p1 == arr1.size) {
            result[i] = arr2[p2++]
        } else if (p2 == arr2.size) {
            result[i] = arr1[p1++]
        } else {
            if (arr1[p1] <= arr2[p2]) {
                result[i] = arr1[p1++]
            } else {
                result[i] = arr2[p2++]
            }
        }
    }

    for (i in result) print("$i ")
}