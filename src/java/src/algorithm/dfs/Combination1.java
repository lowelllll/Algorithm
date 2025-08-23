package algorithm.dfs;

import algorithm.Solution;

import java.util.Scanner;


/**
 * 간단한 조합 구하기
 *
 * input:
 * 4 2
 * output:
 * 1 2
 * 1 3
 * 1 4
 * 2 3
 * 2 4
 * 3 4
 */
public class Combination1 implements Solution {
    int n, m;
    int[] combination;


    public void DFS(int L, int s) { // s는 시작 숫자
        if (L==m) {
            for(int x: combination) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i=s; i<=n; i++) { // 시작 숫자부터 반복
                combination[L] = i;
                DFS(L+1, i+1);
            }
        }
    }

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        combination = new int[m];
        DFS(0, 1);
    }
}
