package prec;

import java.util.Scanner;

public class SnailArr {

	public static void main(String[] args) {
		// 달팽이 배열
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요.>>");
		
	int scale = sc.nextInt();
	
	int[][] arr = new int[scale][scale];
	makeArr(scale,arr);
	printArr(scale,arr);
	
	}
	
	static void makeArr(int n,int[][] arr) {
		int value = 1;
		int row = 0, col = -1; // 행 row 열 col
		int inc = 1; // 증감량
		int i, j;
		while(n > 0) {
			for(i=0; i<n; i++) {
				col += inc; // 열 증가 (inc가 -1이면 감소)
				arr[row][col] = value;
				value++;
  			}
			n--; // 전진하는 양 감소 
			if (n == 0) break; 
			for(i=0; i<n; i++) {
				row += inc;
				arr[row][col] = value;
				value++;
			}
			inc *= -1; // 부호변경
 		}
		
	}
	
	static void printArr(int n,int[][] arr) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.printf("%3d ",arr[i][j]);
			}
			System.out.println();
		}
	}

}
