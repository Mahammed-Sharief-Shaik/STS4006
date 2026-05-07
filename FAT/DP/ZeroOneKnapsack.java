import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZeroOneKnapsack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        // Input weights
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        // Input values
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        int capacity = sc.nextInt();

        // Recursive
        // System.out.println(
        //         knapsackRecursive(weights, values,
        //                 capacity, 0)
        // );

        // Memoization
        // Integer[][] memo =
        //         new Integer[n][capacity + 1];

        // System.out.println(
        //         knapsackMemo(weights, values,
        //                 capacity, 0, memo)
        // );

        // Tabulation
        // System.out.println(
        //         knapsackTabulation(weights,
        //                 values, capacity)
        // );

        // Print selected items
        printSelectedItems(weights, values, capacity);
    }

    // --------------------------------------------------
    // PRINT SELECTED ITEMS
    // --------------------------------------------------

    static void printSelectedItems(int[] weights,
                                   int[] values,
                                   int capacity) {

        int n = weights.length;

        int[][] dp = new int[n + 1][capacity + 1];

        // Fill DP table
        for (int i = 1; i <= n; i++) {

            for (int w = 1; w <= capacity; w++) {

                int notTake = dp[i - 1][w];

                int take = 0;

                if (weights[i - 1] <= w) {

                    take = values[i - 1]
                            + dp[i - 1][w - weights[i - 1]];
                }

                dp[i][w] = Math.max(take, notTake);
            }
        }

        System.out.println(
                "Maximum Profit: " + dp[n][capacity]
        );

        // Backtracking
        List<Integer> selectedItems =
                new ArrayList<>();

        int i = n;
        int w = capacity;

        while (i > 0 && w > 0) {

            // Item not taken
            if (dp[i][w] == dp[i - 1][w]) {
                i--;
            }

            // Item taken
            else {

                selectedItems.add(i - 1);

                w = w - weights[i - 1];

                i--;
            }
        }

        System.out.println(
                "Selected Item Indexes: "
                        + selectedItems
        );
    }

    // --------------------------------------------------
    // TABULATION
    // --------------------------------------------------

    static int knapsackTabulation(int[] weights,
                                  int[] values,
                                  int capacity) {

        int n = weights.length;

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {

            for (int w = 1; w <= capacity; w++) {

                int notTake = dp[i - 1][w];

                int take = 0;

                if (weights[i - 1] <= w) {

                    take = values[i - 1]
                            + dp[i - 1][w - weights[i - 1]];
                }

                dp[i][w] = Math.max(take, notTake);
            }
        }

        return dp[n][capacity];
    }

    // --------------------------------------------------
    // MEMOIZATION
    // --------------------------------------------------

    static int knapsackMemo(int[] weights,
                            int[] values,
                            int capacity,
                            int currentIndex,
                            Integer[][] memo) {

        if (currentIndex == weights.length
                || capacity == 0) {

            return 0;
        }

        if (memo[currentIndex][capacity] != null) {

            return memo[currentIndex][capacity];
        }

        int take = 0;

        if (weights[currentIndex] <= capacity) {

            take = values[currentIndex]
                    + knapsackMemo(weights, values,
                    capacity - weights[currentIndex],
                    currentIndex + 1,
                    memo);
        }

        int notTake = knapsackMemo(weights, values,
                capacity,
                currentIndex + 1,
                memo);

        return memo[currentIndex][capacity] =
                Math.max(take, notTake);
    }

    // --------------------------------------------------
    // RECURSION
    // --------------------------------------------------

    static int knapsackRecursive(int[] weights,
                                 int[] values,
                                 int capacity,
                                 int currentIndex) {

        if (currentIndex == weights.length
                || capacity == 0) {

            return 0;
        }

        int take = 0;

        if (weights[currentIndex] <= capacity) {

            take = values[currentIndex]
                    + knapsackRecursive(weights,
                    values,
                    capacity - weights[currentIndex],
                    currentIndex + 1);
        }

        int notTake = knapsackRecursive(weights,
                values,
                capacity,
                currentIndex + 1);

        return Math.max(take, notTake);
    }
}