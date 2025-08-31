import algorithm.Solution;
import algorithm.sorting.BubbleSort;
import algorithm.sorting.InsertionSort;
import algorithm.sorting.LeastRecentlyUsed;
import algorithm.sorting.SelectionSort;

public class Main {
    public static void main(String[] args) {
        Solution s = new LeastRecentlyUsed();
        s.solve();
    }
}