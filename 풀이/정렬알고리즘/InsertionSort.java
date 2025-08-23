package sort;

public class InsertionSort {

	public static void main(String[] args) {
		// 삽입정렬
		// 내 앞의 숫자들 사이에 삽입한다.
		int[] arr = {8, 5, 2, 4, 1, 3, 7, 6};
		int k=0, j=0;
		for(int i=1; i<arr.length; i++) {
			k = arr[i];
			for(j=i-1; j>=0 && k < arr[j]; j--) { // j가 0보다 크거나 같을 때 , arr[j]가 k보다 클 때 
				arr[j+1] = arr[j];  // 자리를 한칸 씩 미룸
			}
			arr[j+1] = k;
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%d ",arr[i]);
			
		}
	}

}
