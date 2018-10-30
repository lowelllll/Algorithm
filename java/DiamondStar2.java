package prec;

import java.util.Scanner;

public class DiamondStar2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("다이아몬드의 크기를 입력하세요(홀수)>>");
		int column = sc.nextInt();
		int row = column;
		
		for(int i=1; i<=column; i++) {
			// 1분할 
			for(int j=row-i; j>0; j--) {
				System.out.print(' ');
			}
			
			System.out.print('*');
			for(int j=1; j<i; j++) {
				System.out.print(' ');
			}
			
			// 2분할 
			for(int j=1; j<i; j++) {
				if((i-1)==j) 
					System.out.print('*');
				else 
					System.out.print(' ');
			}
			 
			for(int j=row-i; j>0; j--) {
				System.out.print(' ');
			}
			System.out.println();
		}
		
		for(int i=1; i<column; i++) {
			// 3분할
			for(int j=1; j<=i; j++) {
				System.out.print(' ');
			}
			System.out.print('*');
			for(int j=1; j<row-i; j++) {
				System.out.print(' ');
			}
			
			//4분할 
			for(int j=1; j<row-i; j++) {
				if(((column-1)-i)==j) 
					System.out.print('*');
				else 
					System.out.print(' ');
			}
			for(int j=1; j<=i; j++) {
				System.out.print(' ');
			}
			System.out.println();
		}
	}

}
