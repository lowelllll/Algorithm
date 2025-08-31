package algorithm.sorting;

import algorithm.Solution;

import java.util.Scanner;

/**
 * 선택정렬
 * - best O(N^2)
 * - avg O(N^2)
 * - worst O(N^2)
 *
 * input:
 * 6
 * 13 5 11 7 23 15
 *
 * output:
 * 5 7 11 13 15 23
 */
public class SelectionSort implements Solution {

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 선택정렬
        for (int i = 0; i < n; i++) {
            int index = i;
            for (int j = i; j < n; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int tmp =  arr[index];
                arr[index] = arr[i];
                arr[i] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
