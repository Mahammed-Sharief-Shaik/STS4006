import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequence {

    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        dp = new int[s1.length()][s2.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        //System.out.println(lcsRecursive(s1, s2, s1.length() - 1, s2.length() - 1));
        System.out.println(lcsMemoization(s1, s2, s1.length() - 1, s2.length() - 1));
    }

    static int lcsMemoization(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = lcsMemoization(s1, s2, i - 1, j - 1) + 1;
        else {
            return dp[i][j] = Math.max(
                    lcsMemoization(s1, s2, i - 1, j),
                    lcsMemoization(s1, s2, i, j - 1));
        }
    }

    static int lcsRecursive(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0)
            return 0;

        if (s1.charAt(i) == s2.charAt(j))
            return lcsRecursive(s1, s2, i - 1, j - 1) + 1;
        else {
            return Math.max(
                    lcsRecursive(s1, s2, i - 1, j),
                    lcsRecursive(s1, s2, i, j - 1));
        }
    }
}