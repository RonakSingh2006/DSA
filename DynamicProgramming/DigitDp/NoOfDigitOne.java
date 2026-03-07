package DynamicProgramming.DigitDp;

import java.util.Arrays;

class Solution {
    public int countDigitOne(int n) {
        int dp[][][] = new int[10][2][10];

        for(int a2d[][] : dp){
            for(int a[] : a2d) Arrays.fill(a,-1);
        }
        return helper(0,n+"",1,0,dp);
    }

    public int helper(int idx ,  String s , int tight , int cnt ,int dp[][][]){
        if(idx == s.length()) return cnt;

        int limit = (tight == 0) ? 9 : s.charAt(idx) - '0';
        int ans = 0;

        if(dp[idx][tight][cnt] != -1) return dp[idx][tight][cnt];

        for(int i=0 ; i<=limit ; i++){
            
            int nextTight = (tight == 0 || i != limit) ? 0 : 1;
            int nextCnt = cnt + ((i==1) ? 1 : 0);

            ans += helper(idx+1,s,nextTight,nextCnt,dp);

        }

        return dp[idx][tight][cnt] = ans;
    }   
}