import algorithm.Solution;
import algorithm.bfs.IslandBFS;
import algorithm.dfs.IslandDFS;

public class Main {
    public static void main(String[] args) {
        Solution s = new IslandDFS();
        s.solve();
    }
}