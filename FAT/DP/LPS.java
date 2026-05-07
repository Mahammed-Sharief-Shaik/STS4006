import java.util.*;

public class LPS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        // String y = sc.nextLine();

        // LPS Recursive (Using same function as in LCS Recusive )
        // in exam no need to write LCS.lpsRecursive, just call directly with lpsRecursive() 
        System.out.println(LCS.lcsRecursive(x, new StringBuilder(x).reverse().toString(), 0, 0));
       
        // LPS MEMOIZATION (Using same function as in LCS Memoization)
        int[][] memo = new int[x.length()][x.length()];
        for(int[] row : memo) Arrays.fill(row, -1);
        System.out.println(LCS.lcsMemoization(x, new StringBuilder(x).reverse().toString(), 0, 0, memo));

        // LPS Tabulation (Using same function as in LCS Tabulation)
        System.out.println(LCS.lcsTabulation(x, new StringBuilder(x).reverse().toString()));

        // LPS print longest palindromic subsequence
        System.out.println(LCS.printLCS(x,new StringBuilder(x).reverse().toString()));
    }
}
