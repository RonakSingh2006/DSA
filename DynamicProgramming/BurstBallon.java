package DynamicProgramming;

public class BurstBallon {
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = 1;
        System.arraycopy(nums,0,arr,1,n);
        arr[arr.length-1] = 1;

        return helper(arr,1,arr.length-2);
    }
    public static int helper(int arr[] , int i , int j) {

        int max = 0;

        for(int k=i ; k<=j ; k++){
            int val = arr[k]*arr[i-1]*arr[j+1] + helper(arr,k+1,j) + helper(arr,i,k-1);

            max = Math.max(max,val);
        }

        return max;
    }
    public static void main(String[] args) {
        int arr[] = {7,9,8,0,7,1,3,5,5,2,3,3};
        System.out.println(maxCoins(arr));
    }
}
