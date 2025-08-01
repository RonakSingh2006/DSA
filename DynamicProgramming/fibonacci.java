package DynamicProgramming;

import java.util.Arrays;

public class fibonacci {

    // recursion
    public static int fiboRec(int n){
        if(n<=1) return n;
        return fiboRec(n-1) + fiboRec(n-2);
    }

    // memoization
    public static int fiboMemo(int n){
        int arr[] = new int[n+1];
        Arrays.fill(arr,-1);
        memo(n,arr);
        return arr[n];
    } 
    public static int memo(int n , int arr[]){
        if(n<=1) return n;
        if(arr[n]!=-1) return arr[n];
        arr[0] = 0;
        arr[1] = 1;
        return arr[n] = memo(n-1, arr)+memo(n-2, arr);
    }

    // tabulatuion
    public static int fibo(int n){
        if(n<=1) return n;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2 ; i<=n ; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    // Optimised
    public static int fiboOpti(int n){
        if(n<=1) return n;
        int prev2 = 0;
        int prev1 = 1;
        for(int i=2 ; i<=n ; i++){
            int temp = prev2;
            prev2 = prev1;
            prev1 = temp + prev1;
        }
        return prev1;
    }


    public static void main(String[] args) {
        // 0 1 1 2 3 5 8 13 21 34
        // System.out.println(fibo(45));
        // System.out.println(fiboRec(45));
        // System.out.println(fiboMemo(45));
        System.out.println(fiboOpti(46));
    }
}
