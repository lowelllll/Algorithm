package algorithm.sorting;

import algorithm.Solution;

import java.util.Scanner;

/**
 * 삽입 정렬 (정렬된 부분과 정렬되지 않은 부분을 나눔) 
 * - best O(n)
 *  - 이미 정렬되어있는 경우
 * - avg O(n^2)
 * - worst O(n^2)
 */
public class InsertionSort implements Solution {
    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 삽입 정렬
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (tmp < arr[j]) {
                    arr[j + 1] = arr[j]; // 뒤쪽으로 밀어라
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

