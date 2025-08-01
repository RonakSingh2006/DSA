package Sort;
import java.util.Arrays;

class CountSort{
    public static void sort(int arr[]){
        int max = Arrays.stream(arr).max().getAsInt();
        
        // Store freq
        int freq[] = new int[max+1];
        for(int x : arr){
            freq[x]++;
        }

        //prefix
        for(int i=1 ; i<freq.length ; i++){
            freq[i] += freq[i-1];
        }

        int output[] = new int[arr.length];

        for(int i=arr.length-1 ; i>=0 ; i--){
            output[freq[arr[i]]-1] = arr[i];
            freq[arr[i]]--;
        }

        for(int i=0 ; i<arr.length ; i++){
            arr[i] = output[i];
        }
    }
    public static void main(String[] args) {
        int arr[] = {5,4,8,9,10,5,9,6,2,1};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}