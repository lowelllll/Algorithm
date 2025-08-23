package algorithm.dfs;

import algorithm.Solution;
import algorithm.bfs.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaDeliver implements Solution {
    int n, m;
    int[][] board, distance;
    ArrayList<Point> houses =  new ArrayList<Point>();
    ArrayList<Point> pizza =  new ArrayList<Point>();
    int answer = Integer.MAX_VALUE;

    public void DFS(int L, int pi, int sum) {
        if (L==m) {
            if (answer > sum) answer = sum;
        } else {
            for (int i = pi; i < pizza.size(); i++) {
                Point p = pizza.get(i);
                DFS(L + 1, i, sum + distance[p.x][p.y]);
            }
        }
    }

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n+1][n+1];
        distance = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    houses.add(new Point(i, j));
                }
                if (board[i][j] == 2) {
                    pizza.add(new Point(i, j));
                }
            }
        }

        // 피자거리 완성
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i][j] == 2) {
                    // 피자 배달 거리 합
                    int dis = 0;
                    for(Point p : houses){
                        dis += Math.abs(p.x - i) + Math.abs(p.y - j);
                    }
                    distance[i][j] = dis;
                }
            }
        }

        DFS(0, 0, 0);

        System.out.println(answer);
    }
}
