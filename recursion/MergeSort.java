package recursion;
import java.util.Arrays;

public class MergeSort {

    public static void merge(int a[] , int start , int mid , int end){
        int i = start;
        int j = mid+1;

        int copy[] = new int[end-start+1];
        int k =0;

        while(i<=mid && j<=end){
            if(a[i] < a[j]){
                copy[k++] = a[i++];
            }
            else{
                copy[k++] = a[j++];
            }
        }

        while(i<=mid){
            copy[k++] = a[i++];
        }

        while(j<=end){
            copy[k++] = a[j++];
        }
        
        int t = start;
        for(i=0 ; i<k ; i++){
            a[t++] = copy[i];
        }
    }
    public static void sort(int a[] , int start , int end){
        if(start < end){
            int mid = start + (end-start)/2;
            sort(a, start, mid);
            sort(a, mid+1, end);
            merge(a,start,mid,end);
        }
    }
    public static void main(String[] args) {
        // 0 1 2 3 4
        // 5 4 3 2 1
        int arr[] = {5,0,-9,6,5,-8,5,6,3,2,1,4,5,6,96,85,-85,0,25,63,36,69};
        System.out.println(Arrays.toString(arr));
        sort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}