package DynamicProgramming;

import java.util.Arrays;

class LCS{
    public static String lcs(String a , String b){
        int n = a.length() , m = b.length();
        int dp[][] = new int[n+1][m+1];

        for(int i=n-1 ; i>=0 ; i--){
            for(int j=m-1 ; j>=0 ; j--){
                int match = 0 ,noMatch = 0;
                if(a.charAt(i)==b.charAt(j)){
                    match = 1 + dp[i+1][j+1];
                }
                else{
                    noMatch = Math.max(dp[i][j+1],dp[i+1][j]);
                }

                dp[i][j] = Math.max(match, noMatch);
            }
        }

        int i=0, j=0;

        StringBuilder sb = new StringBuilder(); 

        while(i<n && j<m){
            if(a.charAt(i) == b.charAt(j)){
                sb.append(a.charAt(i));
                i++;
                j++;
            }
            else if(dp[i+1][j] >= dp[i][j+1]){
                sb.append(a.charAt(i));
                i++;
            }
            else{
                sb.append(b.charAt(j));
                j++;
            }
        }

        while(i<n){
            sb.append(a.charAt(i++));
        }

        while(j<m){
            sb.append(b.charAt(j++));
        }

        for(int arr[] : dp){
            System.out.println(Arrays.toString(arr));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String a = "abac";
        String b = "cab";

        System.out.println(lcs(a, b));
    }
}