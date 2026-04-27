import java.util.Arrays;
import java.util.Scanner;

public class SubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i]=sc.nextInt();
        int target = sc.nextInt();
        // System.out.println(subsetsum(arr,target,0));

        boolean[][] dp = new boolean[n][target+1];

        for(int i=0; i<n; i++)dp[i][0]= true;
        if(arr[0]<=target) dp[0][arr[0]]=true;

        for(int i=1; i<n; i++){
            for(int t=1; t<=target; t++){
                boolean include = dp[i-1][t];
                boolean exclude = false;
                if(arr[i]<t) include = dp[i-1][t-arr[i]];
                dp[i][t]=include|exclude;
            }
        }
        // for(int i=0; i<n; i++){
        //     dp[i][arr[i]] = true;
        // }
        
        // for(int i=0; i<n; i++){
        //     for(int j=1; j<target+1; j++){
        //         boolean include = dp[i-1][target-arr[i]];
        //         boolean exclude = dp[i-1][target];
        //         dp[i][j] = include || exclude;
        //     }
        // }

        System.out.println(Arrays.deepToString(dp));



    }

    static boolean subsetsum(int[] arr, int target, int i){
        if(i==arr.length) return target==0;
        if(target==0) return true;
        return subsetsum(arr, target-arr[i], i+1) || subsetsum(arr, target, i+1);
    }
    
}
