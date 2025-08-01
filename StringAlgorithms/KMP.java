package StringAlgorithms;

import java.util.ArrayList;

public class KMP {
    ArrayList<Integer> search(String pat, String txt) {
        
        int n = pat.length();
        int m = txt.length();

        ArrayList<Integer> ans = new ArrayList<>();

        if(n > m) return ans;

        // longest prefix equals to suffix suffix
        int lps[] = new int[n];
        int i=1;
        int len = 0;

        while(i<n){
            if(txt.charAt(i) == pat.charAt(len)){
              lps[i++] = len+1;
              len++;
            }
            else{
              if(len!=0) len = lps[len-1];
              else lps[i++] = 0;
            }
        }

        i=0;
        int j=0;


        while(i<m){
            while(j<n && i<m){
              if(pat.charAt(j) == txt.charAt(i)){
                i++;
                j++;
              }
              else{
                if(j==0){
                  i++;
                }
                else{
                  j=lps[j-1];
                }
              }
            }

            if(j==n){
              j=lps[j-1];
              ans.add(i-n);
            }
        }


        return ans;
        
    }
}


class Main{
  public static void main(String[] args) {
    KMP kmp = new KMP();
    System.out.println(kmp.search("geek", "geeksforgeeks"));
  }
}