package sort;

public class SelectionSort {

	public static void main(String[] args) {
		// 선택정렬
		// 가장 작은 값을 선택해서 정렬하는 알고리즘
		
		int[] arr = {3,1,4,5,2};
		int min = 0;
		int tmp = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			min = i;
			for(int j=i; j<arr.length;j++) {
				if(arr[min] > arr[j]) min = j;
			}
			tmp = arr[min];
			arr[min] = arr[i];
			arr[i] = tmp;  
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%d ",arr[i]);
		}
	}

}
