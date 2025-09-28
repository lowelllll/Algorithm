package algorithm.dp;

import algorithm.Solution;

import java.util.Scanner;

/**
 * 동전
 * input:
 * 3
 * 1 2 5
 * 15
 *
 * output:
 * 3
 */
public class Coin implements Solution {

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);

        int coinSize = sc.nextInt();
        int[] coins = new int[coinSize];

        for (int i = 0; i < coinSize; i++) {
            coins[i] = sc.nextInt();
        }

        int amount = sc.nextInt();

        int[] dp = new int[amount+1];

        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for(int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
            }
        }

        System.out.println(dp[amount]);
    }
}
