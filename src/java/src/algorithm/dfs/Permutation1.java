package algorithm.dfs;

import algorithm.Solution;

import java.util.Scanner;

// 수열 추측하기
public class Permutation1 implements Solution {
    int[] b, p, ch;
    int n, f;
    boolean flag = false;
    int[][] dy = new int[35][35];

    public int combi(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n==r || r == 0) return 1;
        else return dy[n][r] = combi(n-1, r-1)+combi(n-1, r);
    }

    public void DFS(int L, int sum) {
        if (flag) return;
        if (L==n) {
            // 순열이 완성됨
            if (sum == f)  {
                for (int x: p) System.out.print(x + " ");
                flag = true;
            }
        } else {
            for (int i=1; i<=n; i++) { // 순열을 만드는 숫자
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i; // 순열을 만듬
                    DFS(L+1, sum+(p[L] * b[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        n =  sc.nextInt(); // 4
        f = sc.nextInt(); // 6

        b = new int[n];
        p = new int[n];
        ch = new int[n+1]; // 1~N까지 사용함

        for (int i = 0; i < n; i++) {
            b[i] = combi(n-1, i);
        }

        DFS(0, 0);
    }
}
