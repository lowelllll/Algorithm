```
package backjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class P3986 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int n = sc.nextInt();
		sc.nextLine();
		int result = 0;
		for (int i=0; i<n; i++) {
			result += goodFriend();
		}
	}
	
	public static int goodFriend() {
		StringStack stack = new StringStack();
		System.out.println("input");
		String input = sc.nextLine();
		char[] friends = input.toCharArray();
		for (int i=0; i<friends.length; i++) {
			if (stack.empty()=='0') {
				stack.push(friends[i]);
			} else if (stack.top()==friends[i]) {
				stack.pop();
			} else if (stack.top()!=friends[i]) {
				stack.push(friends[i]);
			}
		}
		
		System.out.println(input);
		return stack.empty()=='0'?1:0;
	}
}

class StringStack {
	LinkedList<Character> stack = new LinkedList<>();
	
	public int size() {
		return stack.size();
	}
	
	public int empty() {
		return size()>0?0:1;
	}
	public void push (char data) {
		stack.addLast(data);
	}
	
	public char pop() {
		if (empty()==1) return '0';
		char data = stack.getLast();
		stack.removeLast();
		return data;
	}
	
	public char top() {
		if (empty()==1) return '0';
		return stack.getLast();
	}
}




```

