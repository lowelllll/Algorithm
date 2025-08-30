package algorithm.greedy;

import algorithm.Solution;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
    int money;
    int date;

    public Lecture(int money, int date) {
        this.money = money;
        this.date = date;
    }

    // time 기준 내림차순 정렬 필요함
    @Override
    public int compareTo(Lecture o) {
        return o.date -  this.date;
    }
}

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
public class LectureSchedule implements Solution {

    int n;
    int maxTime = 0;
    ArrayList<Lecture> lectures = new ArrayList<>();

    int solution() {
        int answer = 0; // 최대 금액
        Collections.sort(lectures); // 시간순 내림차순 정렬
        // 기본은 작은 값을 우선으로 뽑읍
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); // 큰 값을 기준으로 뽑음

        int j = 0;
        for (int day = maxTime; day >= 1; day--) {
            for (; j < n; j++) {
                Lecture lecture = lectures.get(j);
                if (lecture.date < day) break;
                priorityQueue.add(lecture.money);
            }
            // 하루에 한번씩만 뽑음
            if (!priorityQueue.isEmpty()) {
                answer += priorityQueue.poll(); // 비싼 강의료를 뽑읍
            }
        }
        return answer;
    }

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        n =  sc.nextInt();


        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            int time = sc.nextInt();
            lectures.add(new Lecture(money, time));
            maxTime = Math.max(maxTime, time);
        }

        System.out.println(solution());
    }
}
