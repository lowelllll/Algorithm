package algorithm.greedy;

import algorithm.Solution;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 씨름선수
 *
 * input:
 * 5
 * 172 67
 * 183 65
 * 180 70
 * 170 72
 * 181 60
 *
 * output:
 * 3
 */
class Body implements Comparable<Body>{
    public int h, w;
    Body(int h, int w){
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(@NotNull Body o) {
        return o.h - this.h;
    }
}

public class Player implements Solution {
    static ArrayList<Body> arr;
    int n;

    int solution(){
        int cnt = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for(Body body : arr){
            if (body.w > max) {
                cnt++;
                max =  body.w;
            }
        }
        return cnt;
    }

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new ArrayList<Body>();
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Body(h,w));
        }
        System.out.println(solution());
    }
}
