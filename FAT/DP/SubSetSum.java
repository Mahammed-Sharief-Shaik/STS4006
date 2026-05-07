import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubSetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int target = sc.nextInt();

        // subset sum recursive
        // System.out.println(subsetSumRecursive(arr, target, 0));

        // Memoization
        // Boolean[][] memo = new Boolean[arr.length][target + 1];
        // System.out.println(subsetMemo(arr, target, 0, memo));

        // Tabulation
        // System.out.println(subsetSumTabulation(arr, target));

        // Print subset
        printSubset(arr, target);

    }

    static void printSubset(int[] arr, int target) {
        int n = arr.length;

        boolean[][] dp = new boolean[n + 1][target + 1];

        // Sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= target; j++) {

                boolean notTake = dp[i - 1][j];

                boolean take = false;

                if (arr[i - 1] <= j) {
                    take = dp[i - 1][j - arr[i - 1]];
                }

                dp[i][j] = take || notTake;
            }
        }

        // No subset exists
        if (!dp[n][target]) {
            System.out.println("No subset found");
            return;
        }

        // Backtracking to print subset
        List<Integer> subset = new ArrayList<>();

        int i = n;
        int j = target;

        while (i > 0 && j > 0) {

            // If value came from top
            if (dp[i - 1][j]) {
                i--;
            }

            // Current element was taken
            else {
                subset.add(arr[i - 1]);
                j = j - arr[i - 1];
                i--;
            }
        }

        System.out.println("Subset: " + subset);

    }

    static boolean subsetSumTabulation(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        // Sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                // Not take current element
                boolean notTake = dp[i - 1][j];
                // Take current element
                boolean take = false;
                if (arr[i - 1] <= j) {
                    take = dp[i - 1][j - arr[i - 1]];
                }
                dp[i][j] = take || notTake;
            }
        }
        return dp[n][target];
    }

    static boolean subsetMemo(int[] arr, int target, int currentIndex, Boolean[][] memo) {
        if (target == 0)
            return true;
        if (currentIndex == arr.length)
            return false;

        if (memo[currentIndex][target] != null)
            return memo[currentIndex][target];
        boolean take = false, notTake = false;

        if (arr[currentIndex] <= target) {
            take = subsetMemo(arr, target - arr[currentIndex], currentIndex + 1, memo);
        }

        notTake = subsetMemo(arr, target, currentIndex + 1, memo);

        return memo[currentIndex][target] = take || notTake;
    }

    static boolean subsetSumRecursive(int[] arr, int target, int currentIndex) {
        if (target == 0)
            return true;
        if (currentIndex == arr.length)
            return false;

        boolean take = false, notTake = false;

        if (arr[currentIndex] <= target) {
            take = subsetSumRecursive(arr, target - arr[currentIndex], currentIndex + 1);
        }

        notTake = subsetSumRecursive(arr, target, currentIndex + 1);

        return take || notTake;
    }
}
