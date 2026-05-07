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
        System.out.println(subsetSumRecursive(arr,target,0));

        Boolean[][] memo = new Boolean[arr.length][target];
        subsetMemo(arr, target, n,memo);
    }



    
    static boolean subsetMemo(int[] arr, int target, int currentIndex, Boolean[][] memo){
        if(target==0) return true;
        if(currentIndex==arr.length) return false;

        if(memo[currentIndex][target]!=null) return memo[currentIndex][target];
        boolean take = false, notTake = false;

        if(arr[currentIndex]<=target){
            take = subsetMemo(arr, target-arr[currentIndex], currentIndex+1,memo);
        }

        notTake = subsetMemo(arr, target, currentIndex+1,memo);

        return memo[currentIndex][target] = take || notTake;
    }
    static boolean subsetSumRecursive(int[] arr, int target, int currentIndex){
        if(target==0) return true;
        if(currentIndex==arr.length) return false;

        boolean take = false, notTake = false;

        if(arr[currentIndex]<=target){
            take = subsetSumRecursive(arr, target-arr[currentIndex], currentIndex+1);
        }

        notTake = subsetSumRecursive(arr, target, currentIndex+1);

        return take || notTake;
    }
}
