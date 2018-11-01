package prec;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		for(int i=0; i<num; i++) {
			arr[i] = sc.nextInt();
		}

		int max = arr[start];
		int min = arr[start];
		
		for(int i=start+1; i<=end; i++) {
			  if(max < arr[i])
				  max = arr[i];
			  
			  if(min > arr[i])
				  min = arr[i];
		}
		
		System.out.printf("%d %d",min, max);
	}

}
