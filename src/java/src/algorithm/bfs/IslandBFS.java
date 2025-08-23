package algorithm.bfs;

import algorithm.Solution;

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
public class IslandBFS implements Solution {
    int n;
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    int[][] board; // dfs=최단거리
    int answer = 0;

    public void BFS(int x, int y) {
        answer++;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        board[x][y] = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 1 && nx <= n &&  ny >= 1 && ny <= n && board[nx][ny] != 0) {
                    queue.offer(new Point(nx,ny));
                    board[nx][ny] = 0;
                }
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
                    BFS(i, j);
                }
            }
        }

        System.out.println(answer);
    }
}

