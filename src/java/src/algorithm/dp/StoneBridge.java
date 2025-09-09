package algorithm.dp;

import algorithm.Solution;

import java.util.Scanner;

/**
 * 돌다리 건너기
 * input: 7
 * output: 34 (건너야하니까 n보다 한번 더가야됨)
 */
public class StoneBridge implements Solution {
    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dy = new int[n+1];

        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i-1] + dy[i-2];
        }

        System.out.println(dy[n] + dy[n-1]);

    }
}
