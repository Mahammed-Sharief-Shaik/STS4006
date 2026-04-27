import java.util.Scanner;

public class LongestIncreasingSubsequence {
    //static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // Memoisation
        // dp = new int[n];
        // Arrays.fill(dp, -1);
        // System.out.println(lisMemo(arr, 0, -1));

        int[][] dp = new int[n][n+1];
        for(int i=n-1; i>=0; i--){
            for(int prev=i-1; prev>=-1; prev--){
                int exclude = dp[i+1][prev+1];
                int include = 0;
                if(prev==-1 || arr[prev]<arr[i]) include = dp[i+1][i+1];
                dp[i][prev+1] = Math.max(exclude, include);  
            }
        }
        System.out.println(dp[0][0]);

    }

    // static int lisMemo(int[] arr, int curr, int prev) {
    //     if (curr == arr.length)
    //         return 0;

    //     if (dp[curr] != -1)
    //         return dp[curr];

    //     int include = 0, exclude = 0;
    //     if (prev == -1 || arr[prev] < arr[curr]) {
    //         include = 1 + lisMemo(arr, curr + 1, curr);
    //     }

    //     exclude = lisMemo(arr, curr + 1, prev);

    //     // dp[curr] = Math.max(include, exclude);
    //     // return dp[curr];

    //     return dp[curr] = Math.max(include, exclude);
    // }

}
