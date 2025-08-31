package algorithm.sorting;

import algorithm.Solution;

import java.util.Scanner;

/**
 * 버블 정렬
 * - best O(n^2)
 * - avg O(n^2)
 * - worst O(n^2)
 */
public class BubbleSort implements Solution {
    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 버블 정렬
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
