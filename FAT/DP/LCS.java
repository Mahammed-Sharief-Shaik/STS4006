import java.util.*;

public class LCS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        String y = sc.nextLine();
        // LCS RECURSIVE
        // System.out.println(lcsRecursive(x,y, 0,0));

        // LCS MEMOIZATION
        // int[][] memo = new int[x.length()][y.length()];
        // for (int[] row : memo)
        //     Arrays.fill(row, -1);
        // System.out.println(lcsMemoization(x, y, 0, 0, memo));

        // for (int[] row : memo) {
        //     System.out.println(Arrays.toString(row));
        // }

        // LCS TABULATION
        // System.out.println(lcsTabulation(x, y));

        // LCS PRINT COMMON STRING
        // System.out.println(printLCS(x,y));

        // Count Number of Common Substrings
        System.out.println(countCommonSubsequence(x, y));
    }

    static int countCommonSubsequence(String x, String y) {
        int n = x.length(), m = y.length();
        int[][] dp = new int[n + 1][m + 1];

        // base case: dp[0][*] and dp[*][0] = 0

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    // if characters match total number of subsequences common = # sub-sequences i-1
                    // + # sub-sequences j-1 + 1
                    /*
                     * if till i-1,j the common ss are a, ds
                     * and till i,j-1 common ss are d,ed
                     * then at i,j we get common letter x
                     * then common ss till i,j are :
                     * ax
                     * dsx
                     * dx
                     * edx
                     * x
                     */
                    dp[i][j] = 1 + dp[i - 1][j] + dp[i][j - 1];
                } else {
                    // if letters dont match then number of common sub sequences are :
                    /*
                     * i-1, j ----> common ss : d,e
                     * i, j-1 ----> common ss : de,e
                     * then at i,j ---> d, de, e
                     */
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
                }
            }
        }

        return dp[n][m];
    }

    static String printLCS(String x, String y) {
        int n1 = x.length();
        int n2 = y.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        int i = n1, j = n2;
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                ans.append(x.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else
                j--;
        }

        return ans.reverse().toString();

    }

    static int lcsTabulation(String x, String y) {
        int n1 = x.length();
        int n2 = y.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        // for (int[] row : dp) {
        //     System.out.println(Arrays.toString(row));
        // }
        return dp[n1][n2];
    }

    static int lcsMemoization(String x, String y, int i, int j, int[][] memo) {
        if (i == x.length() || j == y.length())
            return 0;

        if (memo[i][j] != -1)
            return memo[i][j];
        if (x.charAt(i) == y.charAt(j)) {
            return memo[i][j] = 1 + lcsMemoization(x, y, i + 1, j + 1, memo);

        } else {
            return memo[i][j] = Math.max(
                    lcsMemoization(x, y, i + 1, j, memo),
                    lcsMemoization(x, y, i, j + 1, memo));
        }

    }

    static int lcsRecursive(String x, String y, int i, int j) {
        if (i == x.length() || j == y.length())
            return 0;

        if (x.charAt(i) == y.charAt(j)) {
            return 1 + lcsRecursive(x, y, i + 1, j + 1);
        } else {
            return Math.max(
                    lcsRecursive(x, y, i + 1, j),
                    lcsRecursive(x, y, i, j + 1));
        }
    }
}
