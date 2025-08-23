import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cash = {500, 100, 50, 10, 5, 1};
		int money = sc.nextInt();
		int price = sc.nextInt();
		int change = money - price;
		int tmpMoney = 0, result = 0;
		
		for(int idx = 0; idx<cash.length; idx++) {
			if(change == 0) {
				break;
			}
			
			result += change / cash[idx];
			change = change % cash[idx];
		}
		
		System.out.println(result);
		
	}

}
