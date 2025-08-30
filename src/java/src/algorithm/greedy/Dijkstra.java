package algorithm.greedy;

import algorithm.Solution;

import java.util.*;

class SingleEdge implements Comparable<SingleEdge> {
    int v;
    int cost;

    SingleEdge(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(SingleEdge o) {
        return this.cost - o.cost;
    }
}

/**
 * 다익스트라 알고리즘
 *
 * input:
 * 6 9
 * 1 2 12
 * 1 3 4
 * 2 1 2
 * 2 3 5
 * 2 5 5
 * 3 4 5
 * 4 2 2
 * 4 5 5
 * 6 4 5
 *
 * output:
 *2: 11
 * 3: 4
 * 4: 9
 * 5: 14
 */
public class Dijkstra implements Solution {
    int n, m;
    ArrayList<ArrayList<SingleEdge>> graph = new ArrayList<>();
    int[] dis; // 최소 거리

    public void solution(int v) {
        PriorityQueue<SingleEdge> pq = new PriorityQueue<>();
        pq.offer(new SingleEdge(v, 0));
        dis[v] = 0;

        while (!pq.isEmpty()) {
            SingleEdge current = pq.poll(); // 작은 값이 뽑힘

            if (current.cost > dis[current.v]) continue;

            for (SingleEdge next : graph.get(current.v)) {
                if (dis[next.v] > dis[current.v] + next.cost) {
                    dis[next.v] = dis[current.v] + next.cost;
                    pq.offer(new SingleEdge(next.v, dis[next.v]));
                }
            }
        }
    }

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(v1).add(new SingleEdge(v2, cost));
        }

        solution(1);

        for (int i = 1; i <= n; i++) {
            int result = 0;
            if (dis[i] == Integer.MAX_VALUE) {
                result = -1;
            } else {
                result = dis[i];
            }
            System.out.println(i + ": " + result);
        }
    }

}
