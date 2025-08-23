package algorithm.bfs;

import algorithm.Solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    public int x, y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

}
/**
 * 미로의 최단 경로 찾기
 *
 * input:
 * 0 0 0 0 0 0 0
 * 0 1 1 1 1 1 0
 * 0 0 0 1 0 0 0
 * 1 1 0 1 0 1 1
 * 1 1 0 1 0 0 0
 * 1 0 0 0 1 0 0
 * 1 0 1 0 0 0 0
 *
 * output:
 * 12
 */
public class MazeBFS implements Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int[][] board, dis; // dfs=최단거리

    public void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        board[x][y] = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 1 && nx <= 7 &&  ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    queue.offer(new Point(nx,ny));
                    board[nx][ny] = 1;
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }
    }

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        dis = new int[8][8];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        board[1][1] = 1;
        BFS(1, 1); // 시작

        if (dis[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dis[7][7]);
        }
    }

}

