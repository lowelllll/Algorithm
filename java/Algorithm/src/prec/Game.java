package prec;

import java.util.Scanner;

/*
 	3, 6, 9 게임에서 박수 친 수를 계산
 */

public class Game {
		int NONE = -1;
		
		public int game369(int start_Num,int end_Num) {
			int sum = 0;
			for(int i=start_Num;i<=end_Num;i++) {
				String number = Integer.toString(i); 
				if(number.indexOf('3') > NONE || number.indexOf('6') > NONE || number.indexOf('9') > NONE) {
					// indexOf 해당 값이 문자열 몇번 째에 위치해있는지 확인. 없으면 -1 리턴
					sum++;
				};
			}
			return sum;
		}
		
		public static void main(String[] args) {
			Game game = new Game();
			
			int start_Num = 0;
			int end_Num = 0;
			
			Scanner sc = new Scanner(System.in); 
			
			System.out.println("3,6,9 게임을 시작할 숫자와 끝낼 숫자를 입력해주세요.");
			
			System.out.println("시작할 숫자:");
			start_Num = sc.nextInt();
			
			System.out.println("끝낼 숫자:");
			end_Num = sc.nextInt();
			
			System.out.println(game.game369(start_Num,end_Num));
		}
}
