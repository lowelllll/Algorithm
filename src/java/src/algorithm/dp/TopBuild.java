package algorithm.dp;

import algorithm.Solution;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Brick implements Comparable<Brick> {
    int width;
    int height;
    int weight;

    Brick(int width, int height, int weight) {
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(@NotNull Brick o) {
        return this.width - o.width; // 내림차순이여야함
    }
}

/**
 * 가장 높은 탑 쌓기 (LIS 응용)
 * input:
 * 5
 * 25 3 4
 * 4 4 6
 * 9 2 3
 * 16 2 5
 * 1 5 2
 *
 * output:  10
 *
 */
public class TopBuild implements Solution {

    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Brick> bricks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bricks.add(new Brick(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(bricks);

        int answer = 0;
        int[] dp = new int[n];
        dp[0] = bricks.get(0).height;

        for (int i = 1; i < n; i++) {
            Brick brick = bricks.get(i);
            int maxBrickHeight = 0;
            for (int j = 0; j < i; j++) {
                Brick prevBrick = bricks.get(j);
                if (prevBrick.weight < brick.weight && maxBrickHeight < dp[j]) {
                    maxBrickHeight = dp[j];
                }
                dp[i] = maxBrickHeight + brick.height;
            }
            if (dp[i] > answer) answer = dp[i];
        }

        System.out.println( answer);
    }
}
