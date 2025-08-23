import java.util.ArrayList;
import java.util.Scanner;

public class Q5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList list = new ArrayList();
		long num = sc.nextLong();
		long modNum = 0L;
		
		while(num>=1) {
			modNum = num % 2;
			list.add(modNum);
			num = num / 2;
		}
		
		for(int i=0; i<list.size(); i++) {
			if((long) list.get(i) == 1) {
				System.out.printf("%d ", i);
			}
		}
		
	}

}
