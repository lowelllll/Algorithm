package prec;

import java.util.Scanner;

public class FourNumber {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String numbers = sc.nextLine();
		String[] numbers_array = numbers.split("\\s");
		System.out.print(Long.parseLong(numbers_array[0]+numbers_array[1])+Long.parseLong(numbers_array[2]+numbers_array[3]));
	}
}
