package prec;

import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int scope = sc.nextInt();
		for(int i=0; i<scope; i++) {
			for(int j=0; j<scope; j++) {
				if(j>=i) {
					System.out.print("*");
				}else {
					System.out.printf(" ");
				}
			}
			System.out.println();
		}
	}

}
