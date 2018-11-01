package prec;

import java.util.*;
import java.lang.*;
import java.io.*;
class xy{
	int x;
	int y;
	
	public xy(int y,int x) {
		this.x = x;
		this.y = y;
	}
}

class Q7
{
	static int w,h;
	static int[][] map = new int[50][50];
	static int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};//x,y -> x+dir[0],y+dir[1]
	static int[][] visited = new int[50][50];
	public static boolean check(int y,int x) {
		return 0<=x && x<w && 0<=y && y<h;
	}
	public static void dfs(xy start) {
		visited[start.y][start.x] = 1;
		for(int i=0;i<8;i++) {
			int next_x = start.x+dir[i][1];
			int next_y = start.y+dir[i][0];
			if(check(next_y,next_x) && visited[next_y][next_x]==0 && map[next_y][next_x]==1) {
				xy next = new xy(next_y,next_x);
				dfs(next);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt();
		h = sc.nextInt();
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int cnt=0;
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(map[i][j]==1 && visited[i][j]==0){
					xy start = new xy(i,j);
					dfs(start);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
//5 4
//1 0 1 0 0
//1 0 0 0 0
//1 0 1 0 1
//1 0 0 1 0