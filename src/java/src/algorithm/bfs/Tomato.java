package algorithm.bfs;

import algorithm.Solution;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 토마토
 *
 * input:
 * 6 4
 * 0 0 -1 0 0 0
 * 0 0 1 0 -1 0
 * 0 0 -1 0 0 0
 * 0 0 0 0 -1 1
 *
 * output:
 * 4
 */
public class Tomato implements Solution {
    int n, m;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int[][] board, dis; // dfs=최단거리

    public void BFS() {
        Queue<Point> queue = new LinkedList<>();

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i][j] == 1) { // 익은 토마토 집어넣기
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 1 && nx <= m &&  ny >= 1 && ny <= n && board[nx][ny] == 0) { // 익지 않은 토마토
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

        n = sc.nextInt(); // 6
        m = sc.nextInt(); // 4

        board = new int[m+1][n+1];
        dis = new int[m+1][n+1];

        boolean all = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int tomato = sc.nextInt();
                board[i][j] = tomato;

                //  -1: 토마토 없음, 0: 익지 않은 토마토,, 1: 익은 토마토
                if (tomato == 0) {
                    all = false;
                    dis[i][j] = -1;
                    // 토마토가 없으면 dis는 상관 없음
                }
            }
        }

        if (all) { // 토마토가 모두 익어있음
            System.out.println(0);
        } else {
            BFS();
        }

        int answer = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (dis[i][j] == -1) { // 익지 않은 토마토가 있음
                    System.out.println(-1);
                    return;
                }
                if (answer < dis[i][j]) {
                    answer = dis[i][j];
                }
            }
        }
        System.out.println(answer);

    }
}


