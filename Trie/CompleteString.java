package Trie;

import java.util.* ;

class Node{
    Node arr[];
    boolean flag;

    Node(){
      arr = new Node[26];
      flag = false;
    }

    public void put(char x){
      this.arr[x-'a'] = new Node();
    }

    public boolean containsKey(char x){
      return arr[x-'a'] != null;
    }

    public void setEnd(){
      this.flag = true;
    }

    public boolean isEnd(){
      return flag;
    }

    public Node next(char x){
      return arr[x-'a'];
    }
  }

  class Trie{
    Node root;

    Trie(){
      root = new Node();
    }


    public void insert(String s){
      Node curr = root;

      for(int i=0 ; i<s.length() ; i++){
        char ch = s.charAt(i);

        if(!curr.containsKey(ch)){
          curr.put(ch);
        }

        curr = curr.next(ch);
      }

      curr.setEnd();
    }

    public boolean containsString(String s){
      Node curr = root;
      for(int i=0 ; i<s.length() ; i++){
        char ch = s.charAt(i);

        if(!curr.containsKey(ch)){
          return false;
        }

        curr = curr.next(ch);
      }

      return curr.isEnd();
    }

    public boolean complete(String s){
      Node curr = root;
      for(int i=0 ; i<s.length() ; i++){
        char ch = s.charAt(i);

        if(!curr.containsKey(ch)) return false;

        curr = curr.next(ch);
        if(!curr.isEnd()) return false;

      }

      return true;
    }
  }
class CompleteStringSolution {

  public static String completeString(int n, String[] a) {
    // Write your code here.

    Arrays.sort(a);

    Trie tr = new Trie();
    for(String x : a){
      tr.insert(x);
    }

    String ans = "";

    for(String x : a){
      if(tr.complete(x)){
          if(x.length() > ans.length()){
            ans = x;
          }
      }
    }



    if(ans.equals("")) return "None";

    return ans;

  }
  public static void main(String[] args) {
    String arr[] = { "ab" , "abc" , "a" , "bp" };
    System.out.println(completeString(4, arr));
    
  }
}