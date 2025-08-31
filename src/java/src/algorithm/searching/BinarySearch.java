package algorithm.searching;

import algorithm.Solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 이분탐색
 * input:
 * 8 32
 * 23 87 65 12 57 32 99 81
 *
 * output:
 * 3
 */
public class BinarySearch implements Solution {

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int lt = 0;
        int rt = n-1;

        int answer = 0;
        while (lt <= rt) {
            int mid = (rt+lt)/2;
            if (arr[mid] == target) {
                answer = mid+1;
                break;
            } else if (arr[mid] < target) {
                lt = mid+1;
            } else {
                rt = mid-1;
            }
        }

        System.out.println(answer);
    }
}
