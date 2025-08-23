package algorithm.dfs;

import algorithm.Solution;

import java.util.Scanner;

public class MazeDFS implements Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int[][] board;
    int answer = 0;

    public void DFS(int x, int y) {
        if (x==7 && y == 7) {
            answer++;
        } else {
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny]==0) {
                    board[x][y] = 1;
                    DFS(nx, ny);
                    board[x][y] = 0;
                }
            }
        }
    }

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        board[1][1] = 1;
        DFS(1, 1); // 시작
        System.out.println(answer);
    }
}
