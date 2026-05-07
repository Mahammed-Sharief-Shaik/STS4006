import java.util.*;

public class LIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // LIS RECURSIVE
        // System.out.println(lisRecursive(arr,0,-1));

        // LIS Memoization
        // int[][] memo = new int[n][n+1];
        // for(int[] row : memo) Arrays.fill(row,-1);
        // System.out.println(lisMemoization(arr,0,-1,memo));

        // LIS Tabulation
        System.out.println(lisTabulation(arr));

        // Print LIS
        printLIS(arr);

    }

    static void printLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            parent[i] = i;
        }

        int maxLIS = 0;
        int lastIndex = -1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLIS) {
                maxLIS = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> lis = new ArrayList<>();
        while (parent[lastIndex] != lastIndex) {
            lis.add(arr[lastIndex]);
            lastIndex = parent[lastIndex];
        }
        lis.add(arr[lastIndex]); // add first element

        Collections.reverse(lis);
        System.out.println(lis);
    }

    static int lisTabulation(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        // dp[i] indicates length of LIS ending at index i
        Arrays.fill(dp, 1);
        int maxLIS = 0;
        for (int i = 1; i < n; i++) { // check for all numbers from index 1 as for index 0 -> length of LIS ending at
                                      // 0 is 1
            for (int j = 0; j < i; j++) { // iterates through all indices less than i
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // extend the previous subsequence ending at j + 1
                    maxLIS = Math.max(dp[i], maxLIS);
                }
            }
        }
        return maxLIS;

    }

    static int lisMemoization(int[] arr, int currentIndex, int previousIndex, int[][] memo) {
        if (currentIndex == arr.length)
            return 0;
        if (memo[currentIndex][previousIndex + 1] != -1)
            return memo[currentIndex][previousIndex + 1];
        int take = 0, notTake = 0;
        // TAKE
        if (previousIndex == -1 || arr[previousIndex] < arr[currentIndex])
            take = 1 + lisMemoization(arr, currentIndex + 1, currentIndex, memo);
        // Not Take
        notTake = lisMemoization(arr, currentIndex + 1, previousIndex, memo);
        return memo[currentIndex][previousIndex + 1] = Math.max(take, notTake);
    }

    static int lisRecursive(int[] arr, int currentIndex, int previousIndex) {
        if (currentIndex == arr.length)
            return 0;

        int take = 0, notTake = 0;

        // TAKE
        if (previousIndex == -1 || arr[previousIndex] < arr[currentIndex])
            take = 1 + lisRecursive(arr, currentIndex + 1, currentIndex);

        // Not Take
        notTake = lisRecursive(arr, currentIndex + 1, previousIndex);

        return Math.max(take, notTake);
    }
}
