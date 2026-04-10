import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fiboRecursive(n));
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(fiboMemo(n));

        System.out.println(fiboTab(n));
    }

    static int fiboRecursive(int n){
        if(n==0 || n==1) return n;
        return fiboRecursive(n-1)+ fiboRecursive(n-2);
    }

    static int fiboMemo(int n){
        if(n==0 || n==1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = fiboMemo(n-1) + fiboMemo(n-2);
    }

    static int fiboTab(int n){
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2; i<=n; i++) dp[i]=dp[i-1]+dp[i-2];
        return dp[n];
    }
    
}
