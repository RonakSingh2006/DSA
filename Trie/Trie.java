// package Trie;

// public class Trie {
//     class Node{
//         Node arr[];
//         boolean flag;

//         Node(){
//             arr = new Node[26];
//             flag = false;
//         }
//     }

//     Node root;

//     public Trie() {
//         root = new Node();   
//     }
    

//     public void insert(String word) {
//         int i=0;

//         Node curr = root;
//         while(i<word.length()){

//             char ch = word.charAt(i);
//             if(curr.arr[ch-'a'] == null){
//                 curr.arr[ch-'a'] = new Node();
//             }

//             curr = curr.arr[ch-'a'];

//             i++;
//         }

//         // word ends
//         curr.flag = true;
//     }
    
//     public boolean search(String word) {
//         Node curr = root;
//         int i=0;
//         while(curr != null && i<word.length()){
//             char ch = word.charAt(i);
//             if(curr.arr[ch-'a'] == null) return false;

//             curr = curr.arr[ch-'a'];

//             i++;
//         }

//         if(curr == null) return false;


//         return curr.flag;
//     }
    
//     public boolean startsWith(String prefix) {
//         Node curr = root;
//         int i=0;
//         while(curr != null && i<prefix.length()){
//             char ch = prefix.charAt(i);
//             if(curr.arr[ch-'a'] == null) return false;

//             curr = curr.arr[ch-'a'];

//             i++;
//         }

//         return i == prefix.length();
//     }
// }

// /**
//  * Your Trie object will be instantiated and called as such:
//  * Trie obj = new Trie();
//  * obj.insert(word);
//  * boolean param_2 = obj.search(word);
//  * boolean param_3 = obj.startsWith(prefix);
//  */