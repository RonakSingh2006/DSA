package Sort;
import java.util.Arrays;

class RadixSort{
    public static void sort(int arr[]){
        int max = Arrays.stream(arr).max().getAsInt();

        for(int exp = 1; exp<=max ; exp*=10){
            countSort(arr,exp);
        }
    }
    public static void countSort(int arr[] , int exp){
        int count[] = new int[10]; // 0-9
        int output[] = new int[arr.length];

        for(int x : arr){
            count[(x/exp)%10]++;
        }
        
        for(int i=1 ; i<10 ; i++){
            count[i] += count[i-1];
        }

        for(int i=arr.length-1 ; i>=0 ; i--){
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }

        for(int i=0 ; i<arr.length ; i++){
            arr[i] = output[i];
        }
    }
    public static void main(String[] args) {
        int arr[] =  {5,9,10,100,8,859,7053,682};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}