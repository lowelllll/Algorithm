package algorithm.greedy;

import algorithm.Solution;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time>{
    public int time;
    public char state;

    Time(int time, char state){
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(@NotNull Time o) {
        if (this.time == o.time) return this.state - o.state; // 시간이 같으면 알파벳 기준으로 정렬
        else return this.time - o.time;
    }
}

/**
 * 결혼식
 *
 * input:
 * 5
 * 14 18
 * 12 15
 * 15 20
 * 20 30
 * 5 14
 *
 * output:
 * 2
 *
 */
public class Merry implements Solution {
    ArrayList<Time> arr = new ArrayList<>();

    int solution() {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr); // 시간순 -> 알파벳으로 정렬

        int cnt = 0;
        for (Time time : arr) {
            if (time.state == 's') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int sT =  sc.nextInt();
            int eT =  sc.nextInt();
            arr.add(new Time(sT, 's'));
            arr.add(new Time(eT, 'e'));
        }
        System.out.println(solution());

    }
}
