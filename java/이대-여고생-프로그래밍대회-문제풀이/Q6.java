package prec;

import java.util.*;
public class Q6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String[] results = new String[num];
		int i=0;
		
		sc.nextLine();
		
		loop : while(i<num) {
			Stack stack = new Stack();
			String tmpBracket = sc.nextLine();
			char[] bracket = tmpBracket.toCharArray();
			System.out.println(bracket);
			for(int j=0; j<bracket.length; j++) {
				if(bracket[j] == '(') {
					stack.push(bracket[j]);
				}else {
					if(stack.isEmpty()) {
						results[i] = "NO";
						System.out.println(results[i]);
						continue loop;
					}else {
						stack.pop();
					}
				}
			}

			if(!stack.isEmpty()) {
				results[i] = "NO";
			}else {
				results[i] = "YES";
			}
			
			System.out.println(results[i]);
			i++;
		}
	}
}
