package DynamicProgramming;

import java.util.Arrays;

class BooleanExpression {
    static int countWays(String s) {
        // code here
        int n = s.length();
        int dp[][][] = new int[n][n][2];
        for(int a2d[][] : dp){
            for(int a[] : a2d){
                Arrays.fill(a,-1);
            }
        }

        return helper(s, 0, s.length()-1, 1,dp);
        
    }

    public static int helper(String s , int i , int j , int isTrue, int dp[][][]){
        if(i>j) return 0;
        if(i==j){
            if(isTrue==1 && s.charAt(i)=='T'){
                return 1;
            }
            else if(isTrue == 0 && s.charAt(i)=='F'){
                return 1;
            }
            else return 0;
        }

        if(dp[i][j][isTrue] != -1) return dp[i][j][isTrue];

        int count = 0;

        for(int k=i ; k<=j ; k++){
            char ch = s.charAt(k);
            if(ch == '|' || ch=='&' || ch=='^'){
                int lf = helper(s,i,k-1,0,dp); // left false
                int lt = helper(s,i,k-1,1,dp); // left true
    
                int rf = helper(s,k+1,j,0,dp); // right false
                int rt = helper(s,k+1,j,1,dp); // right true;

                int val = 0;

                if(ch=='|'){
                    if(isTrue == 1){
                        val = (lf*rt) + (lt*rf) + (lt*rt);
                    } 
                    else val = (lf*rf);
                }
                else if(ch=='&'){
                    if(isTrue == 1){
                        val = (lt*rt);
                    }
                    else{
                        val = (lf*rt) + (lt*rf) + (lf*rf);
                    }
                }
                else{
                    if(isTrue == 1){
                        val = (lf*rt) + (lt*rf);
                    }
                    else{
                        val = (lf*rf) + (lt*rt);
                    }
                }

                count += val;
            }
        }

        return dp[i][j][isTrue] = count;
    }
    public static void main(String[] args) {
        String s = "T|T&F^T";
        System.out.println(countWays(s));

    }
}