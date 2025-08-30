package algorithm.greedy;

import algorithm.Solution;

import java.util.Scanner;

/**
 * 친구인가?
 * input:
 * 9 7
 * 1 2
 * 2 3
 * 3 4
 * 1 5
 * 6 7
 * 7 8
 * 8 9
 * 3 8
 *
 * output:
 * NO
 */
public class UnionFind implements Solution {
    int friendCount, intputCount;
    int[] unf;

    int find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = find(unf[v]); // unf[v] 지정시 경로 압축함
    }

    void union(int p, int q) {
        int fa = find(p);
        int fb = find(q);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        friendCount = sc.nextInt();
        intputCount = sc.nextInt();

        // unf 초기화 -> 친구 그룹
        unf = new int[friendCount + 1];
        for (int i = 1; i <= friendCount; i++) unf[i] = i;

        for (int i = 1; i <= intputCount; i++){
            union(sc.nextInt(), sc.nextInt());
        }

        if (find(sc.nextInt()) == find(sc.nextInt())) { // 친구 그룹이 같으면 친구임
            System.out.println("YES");
        } else {
            System.out.println("NO");
        };
    }
}
