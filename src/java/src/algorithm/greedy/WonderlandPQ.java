package algorithm.greedy;

import algorithm.Solution;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
    int v;
    int cost;

    Node(int v, int cost){
        this.v = v;
        this.cost = cost;
    }


    @Override
    public int compareTo(@NotNull Node o) {
        return this.cost - o.cost;
    }
}

public class WonderlandPQ implements Solution {
    int nodeCount;
    int edgeCount;
    int[] checked;

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        nodeCount = sc.nextInt();
        edgeCount = sc.nextInt();

        // 초기화
        ArrayList<ArrayList<Node>> totalNodes = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            totalNodes.add(new ArrayList<>());
        }

        checked = new int[nodeCount+1];


        for (int i = 0; i < edgeCount; i++) {
            int v1 =  sc.nextInt();
            int v2 =  sc.nextInt();
            int cost = sc.nextInt();

            totalNodes.get(v1).add(new Node(v2, cost));
            totalNodes.get(v2).add(new Node(v1, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(1, 0));

        int answer = 0;

        while (!pq.isEmpty()){
            Node node = pq.poll();
            if (checked[node.v] == 0) {
                checked[node.v] = 1;
                answer+=node.cost;
            }
            for(Node next: totalNodes.get(node.v)){
                if (checked[next.v] == 0) {
                    pq.offer(next);
                }
            }
        }

        System.out.println(answer);
    }
}
