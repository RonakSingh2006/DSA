package DynamicProgramming;

import java.util.Arrays;

class Solution {
    static int dp[];
    public static int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        System.out.println(Arrays.toString(dp));
        return helper(coins,amount,0,0);
    }
    public static int helper(int[] coins, int amount , int index , int count) {
        if(amount == 0) return count;
        if(index == coins.length || amount < 0) return -1;

        if(dp[amount]!=0){
            return dp[amount];
        }
        int take = helper(coins,amount-coins[index],index,count+1);
        
        int notTake = helper(coins,amount,index+1,count);

        if(take != -1 && notTake != -1){
            dp[amount] = Math.min(take,notTake);
        } 
        else{
            dp[amount] = take==-1?notTake:take;
        } 

        return dp[amount];
    }
    public static void main(String[] args) {
        int arr[] = {1,2,5};
        System.out.println(coinChange(arr, 11));
    }
}