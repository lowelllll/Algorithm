package algorithm.dp;

import algorithm.Solution;

import java.util.Scanner;

/**
 * 최대 부분 증가 수열
 *
 * input:
 * 8
 * 5 3 7 8 6 2 9 4
 *
 * output:
 * 4
 *
 */
public class MaxSequence implements Solution {

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n+1];
        dp[1] = 1;

        int globalMax = 0;
        for (int i = 2; i <= n; i++) {
            int maxIndex = 0;
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i] && dp[maxIndex] < dp[j]) {
                    maxIndex = j;
                }
            }

            dp[i] = dp[maxIndex] + 1;

            if (globalMax < dp[i]) {
                globalMax = dp[i];
            }
        }


        System.out.println(globalMax);
    }
}
