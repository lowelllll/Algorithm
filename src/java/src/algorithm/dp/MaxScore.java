package algorithm.dp;

import algorithm.Solution;

import java.util.Scanner;

/**
 * 최대 점수 구하기 (냅색 알고리즘)
 * - 개수가 유한하기 때문에 뒤에서부터 푼다
 * input:
 * 5 20
 * 10 5
 * 25 12
 * 15 8
 * 6 3
 * 7 4
 * output:
 * 41
 *
 */
public class MaxScore implements Solution {

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 문제 개수
        int m = sc.nextInt(); // 최대 시간

        int[] dy = new int[m+1];

        for (int i = 0; i < n; i++) {
            int ps = sc.nextInt();
            int pt = sc.nextInt();
            for (int j = m; j>= pt; j--) {
                dy[j] = Math.max(dy[j], dy[j-pt] + ps);
            }
        }

        System.out.println(dy[m]);
    }
}
