import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MaximumSlidingWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> result = findMaxWindow(arr,k);
        System.out.println(result);
    }

    static List<Integer> findMaxWindow(int[] arr, int k){
        List<Integer> result = new ArrayList<>();

        Deque<Integer> dq = new LinkedList<>();
        int n = arr.length;

        for(int i=0; i<n; i++){
            int curr = arr[i];
            /*
                here i is end of window
                remove unwanted values that a not part of current window
                if i = 5, k=3 then the values in window are 3,4,5 but anything <3 is not in the current window
                it can be found using i-k
                anything less than i-k will not be in the window
            */ 

            if(!dq.isEmpty() && dq.peekFirst()<=i-k) dq.pollFirst();
            while(!dq.isEmpty() && arr[dq.peekLast()]<=curr) dq.pollLast();
            dq.offerLast(i);
            if(i>=k-1) result.add(arr[dq.peekFirst()]);
        }
        return result;

    }
}
