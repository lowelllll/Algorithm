package prec;

import java.util.*;
public class Q3 {
	public static void main(String[] args) {
		HashMap<String, int[]> map = new HashMap<>();
		map.put("black", new int[]{0, 1});
		map.put("brown", new int[]{1, 10});
		map.put("red", new int[] {2, 100});
		map.put("orange", new int[] {3, 1000});
		map.put("yellow", new int[] {4, 10000});
		map.put("green", new int[] {5, 100000});
		map.put("blue", new int[] {6, 1000000});
		map.put("violet", new int[] {7, 10000000});
		map.put("gray", new int[] {8, 100000000});
		map.put("white", new int[] {9, 1000000000});
		
		Scanner sc = new Scanner(System.in);
		String tmpNum1 = sc.nextLine();
		String tmpNum2 = sc.nextLine();
		String tmpMul = sc.nextLine();
		
		int num1 = map.get(tmpNum1)[0];
		int num2 = map.get(tmpNum2)[0];
		
		int mulValue = map.get(tmpMul)[1];
		
		System.out.println(((num1*10)+num2)*mulValue);
	}

}
