package greedy

import java.util.PriorityQueue
import java.util.Scanner

/**
 * 최대 수입 스케쥴
 * input:
 * 6
 * 50 2
 * 20 1
 * 40 2
 * 60 3
 * 30 3
 * 30 1
 *
 * output:
 * 150
 */
fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val lessons = Array(n) { sc.nextInt() to sc.nextInt() } // 강의료 to 기한

    lessons.sortByDescending { it.second } // 기한이 많이 남은 순으로 정렬

    // 강의료 비싼 순으로 뽑기
    val pq = PriorityQueue<Int>(compareByDescending { it })

    val maxDate = lessons.maxBy { it.second }.second

    var i = 0
    var answer = 0
    for(date in maxDate downTo 1) {
        while(i < n && lessons[i].second >= date) {
            pq.add(lessons[i].first)
            i++
        }

        if (pq.isNotEmpty()) {
            answer += pq.poll()
        }
    }

    println(answer)
}