package algorithm.greedy;

import algorithm.Solution;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int cost;

    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) { // cost 오름차순
        return this.cost - o.cost;
    }
}
public class Wonderland implements Solution {
    int[] unf;
    int nodeCount;
    int edgeCount;

    int find(int x) {
        if (x == unf[x]) return x;
        else return unf[x] = find(unf[x]);
    }

    void union(int x, int y) {
        int fa = find(x);
        int fb = find(y);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        nodeCount = sc.nextInt();
        edgeCount = sc.nextInt();

        unf = new int[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) unf[i] = i;

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < edgeCount; i++) {
            int v1 =  sc.nextInt();
            int v2 =  sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(v1, v2, cost));
        }

        Collections.sort(edges); // cost 기준 오름차순 정렬

        int answer = 0;
        int e = 0;
        for(Edge edge: edges) {
            if (e == nodeCount - 1) break; // 트리가 모두 만들어졌다면 break (트리의 간선 수는 노드 수 -1)
            int fa = find(edge.v1);
            int fb = find(edge.v2);

            if (fa != fb) { // 한 집합이 아니라면 (회로를 만들지 않기 위함)
                answer += edge.cost;
                union(edge.v1, edge.v2);
                e++;
            }
        }
        System.out.println(answer);
    }
}
