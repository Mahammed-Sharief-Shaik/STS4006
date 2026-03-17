//Heap sort
//Max Heap do min heap as HW
// left child index=2(parent index)+1
// right child index=2(parent index)+2
import java.util.*;
public class HeapSort{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        heapsort(n,arr);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+ " ");
        }
    }
    static void heapsort(int n,int[] arr){
        for(int i=(n/2)-1;i>=0;i--){
            heapify(n,arr,i);
        }
        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(i,arr,0);
        }
    }
    static void heapify(int n,int[] arr,int parent){
        int left=2*parent+1;
        int right=2*parent+2;
        int max=parent;
        if(left<n && arr[left]>arr[max]){
            max=left;
        }
        if(right<n && arr[right]>arr[max]){
            max=right;
        }
        if(max!=parent){
            int temp=arr[max];
            arr[max]=arr[parent];
            arr[parent]=temp;
            heapify(n,arr,max);
        }
    }
}