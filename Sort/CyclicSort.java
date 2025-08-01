package Sort;

import java.util.Arrays;

public class CyclicSort {
    public static void swap(int i , int j , int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void sort(int arr[]){
        int i=0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap(i,correct,arr);
            }
            else i++;
        }
    }
    public static void main(String[] args) {
        int arr[] = {3,2,1,4,3};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
