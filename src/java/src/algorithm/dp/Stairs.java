package algorithm.dp;

import algorithm.Solution;

import java.util.Scanner;

/**
 * 계단 오르기
 *
 * input:
 * 7
 *
 * output:
 * 21
 */
public class Stairs implements Solution {

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dy = new int[n+1];

        dy[1] = 1;
        dy[2] = 2;

        for (int i=3; i<=n; i++) {
            dy[i] = dy[i-2] + dy[i-1];
        }
        System.out.println(dy[n]);
    }
}
