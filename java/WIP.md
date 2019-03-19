```
package bfs;


import tool.Tool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Fire {
    char[][] building;
    int[][] visit;
    int[][] fVisit;
    int M, N;

    int[] me = new int[2]; // 내위치
    ArrayList<int[]> fires = new ArrayList<int[]>(); // 불위치

    int[][] dir = {{0,-1}, {-1,0}, {0, 1}, {1, 0}};

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            Fire f = new Fire();
            f.process(sc);
        }
    }

    void process(Scanner sc) {
        this.M = sc.nextInt();
        this.N = sc.nextInt();

        sc.nextLine();

        this.building = new char[this.N][this.M];
        this.visit = new int[this.N][this.M];
        this.fVisit = new int[this.N][this.M];

        for (int i=0; i<this.N; i++) {
            String input = sc.nextLine();
            char[] data = input.toCharArray();
            for(int j=0; j<data.length; j++) {
                this.building[i][j] = data[j];
                if(data[j] == '@') {
                    this.me[0] = i;
                    this.me[1] = j;
                } else if (data[j] == '*') {
                    int[] firePath = {i, j};
                    this.fires.add(firePath);
                }
            }
        }
//        System.out.println(this.me[0]);
//        System.out.println(this.me[1]);
        bfs();
    }

    boolean check(int x, int y) {
        return 0 <= x && x < this.N && 0 <= y && y < this.M;
    }

    boolean isEscape(int x, int y) {
        return (x == 0 || x == this.N-1) || (y == 0 || y == this.M-1);
    }

    void bfs(){
        if(isEscape(this.me[0], this.me[1])) {
//            System.out.println(this.me[0]);
//            System.out.println(this.me[1]);
            System.out.println(1);
            return;
        }

        Queue<int[]> myQueue = new LinkedList<>();
        ((LinkedList<int[]>) myQueue).add(this.me);
        this.visit[this.me[0]][this.me[1]] = 1;
        int cnt = 0;

        Queue<int[]> fireQueue = new LinkedList<>();
        for(int[] path: this.fires){
            ((LinkedList<int[]>) fireQueue).add(path);
        }

        int next_x, next_y;
        int last_x = -1, last_y = -1;

        while(!myQueue.isEmpty()) {
            int fireSize = fireQueue.size();
            for(int i=0; i<fireSize; i++) {
                int[] cur_fire = fireQueue.poll();
                for (int j = 0; j < this.dir.length; j++) {
                    next_x = cur_fire[0] + this.dir[j][0];
                    next_y = cur_fire[1] + this.dir[j][1];

                    if (check(next_x, next_y) && this.building[next_x][next_y] == '.' && this.fVisit[next_x][next_y] != 1) {
                        int[] next = {next_x, next_y};
                        ((LinkedList<int[]>) fireQueue).add(next);
                        this.building[next_x][next_y] = '*';
                    }
                }
            }

            int size = myQueue.size();
            for(int j=0; j<size; j++) {
                int[] cur = ((LinkedList<int[]>) myQueue).poll();

                for (int i = 0; i < this.dir.length; i++) {
                    next_x = cur[0] + this.dir[i][0];
                    next_y = cur[1] + this.dir[i][1];

                    if (check(next_x, next_y) && this.building[next_x][next_y] == '.' && this.visit[next_x][next_y] != 1) {
                        int[] next = {next_x, next_y};
                        ((LinkedList<int[]>) myQueue).add(next);
                        this.visit[next_x][next_y] = 1;
                    }
                }
//                System.out.println(cur[0]+""+cur[1]);
                last_x = cur[0];
                last_y = cur[1];
            }

            cnt++;
            if(isEscape(last_x, last_y)) {
                System.out.println(cnt);
                return;
            }
//            Tool.print2Arr(this.building);
//            System.out.println();
        }

        // 나왔는지 확인
        if(isEscape(last_x, last_y)) {
            System.out.println(cnt);
        } else {
            System.out.println("IMPOSSIBLE");
        }


    }
}


```

