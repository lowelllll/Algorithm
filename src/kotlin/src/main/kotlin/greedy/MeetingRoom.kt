package greedy

import java.util.*

/**
 * 회의실 배정
 * input:
 * 5
 * 1 4 (시작 ~ 종료)
 * 2 3
 * 3 5
 * 4 6
 * 5 7
 *
 * output:
 * 3
 */
fun main() {
    val sc = Scanner(System.`in`)
    val meetingSize = sc.nextInt()
    val meetings = Array(meetingSize) { sc.nextInt() to sc.nextInt() }

    // 빨리 끝나는 순, 같은 값이면 시작 시각이 빠른 순
    meetings.sortWith(compareBy({ it.second }, { it.first }))

    var answer = 0
    var prevEnd = 0
    for (meeting in meetings) {
        if (prevEnd <= meeting.first) {
            answer ++
            prevEnd = meeting.second
        }
    }

    println(answer)
}