package algorithm.dfs;

import algorithm.Solution;
import algorithm.bfs.Point;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 섬 개수 찾기
 *
 * input:
 * 7
 * 1 1 0 0 0 1 0
 * 0 1 1 0 1 1 0
 * 0 1 0 0 0 0 0
 * 0 0 0 1 0 1 1
 * 1 1 0 1 1 0 0
 * 1 0 0 0 1 0 0
 * 1 0 1 0 1 0 0
 *
 * output:
 * 5
 */
public class IslandDFS implements Solution {
    int n;
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    int[][] board;
    int answer = 0;

    public void DFS(int x, int y) {
        board[x][y] = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 1 && nx <= n &&  ny >= 1 && ny <= n && board[nx][ny] != 0) {
                DFS(nx, ny);
            }
        }
    }

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    DFS(i, j);
                }
            }
        }

        System.out.println(answer);
    }
}

