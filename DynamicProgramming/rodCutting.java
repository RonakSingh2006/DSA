package DynamicProgramming;

import java.util.Arrays;

class RodCut {
    public static int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);

        int arr[] = new int[cuts.length+2];
        arr[0] = 0;
        System.arraycopy(cuts,0,arr,1,cuts.length);
        arr[arr.length-1] = n;

        int m = arr.length;

        int dp[][] = new int[m][m];
        for(int a[] : dp){
            Arrays.fill(a,-1);
        }

        return cut(arr,0,arr.length-1,dp);

    }

    public static int cut(int arr[] , int i , int j,int dp[][]){
        if(j-i == 1) return 0;
        int min = Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        for(int k=i+1 ; k<j ; k++){
            int val = cut(arr,i,k,dp) + cut(arr,k,j,dp) + arr[j]-arr[i];

            min = Math.min(min,val);
        }

        return dp[i][j] = min;
    }
    public static void main(String[] args) {
        int arr[] = {5,6,1,4,2}; // 22 ans
        System.out.println(minCost(9, arr));
       
    }
}