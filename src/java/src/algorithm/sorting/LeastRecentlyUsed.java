package algorithm.sorting;

import algorithm.Solution;

import java.util.Scanner;

/**
 * Least Recently Used
 *
 * input:
 * 5 9
 * 1 2 3 2 6 2 3 5 7
 *
 * output:
 * 7 5 3 2 6
 */
public class LeastRecentlyUsed implements Solution {
    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int cacheSize = sc.nextInt();
        int n = sc.nextInt();

        int[] cache = new int[cacheSize];

        for (int i = 0; i < n; i++) {
            int process =  sc.nextInt();

            int pi = cacheSize-1;
            for (int ci = 0; ci < cacheSize; ci++) {
                if (cache[ci] == process) {
                    pi = ci;
                    break;
                }
            }

            int j = pi - 1;
            for (; j >= 0; j--) {
                cache[j+1] = cache[j];
            }

            cache[j+1] = process;
        }

        for (int i = 0; i < cacheSize; i++) {
            System.out.print(cache[i] + " ");
        }
    }

}


