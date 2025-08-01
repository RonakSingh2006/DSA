// /*You are required to complete this method */
// class Node{
//     Node arr[];
    
//     Node(){
//         arr = new Node[26];
//     }
    
//     public boolean containsKey(char x){
//         return arr[x-'a'] != null;
//     }
    
//     public void put(char x){
//         arr[x-'a'] =  new Node();
//     }
    
//     public Node next(char x){
//         return arr[x-'a'];
//     }
// }
// class Trie{
//     Node root;
//     Trie(){
//         root = new Node();
//     }
    
//     public int countDistinct(String s){
//         int cnt = 0;
        
//         for(int i=0 ; i<s.length() ; i++){
//             Node curr = root;
            
//             for(int j=i ; j<s.length() ; j++){
//                 char ch = s.charAt(j);
                
//                 if(!curr.containsKey(ch)){
//                     cnt++;
//                     curr.put(ch);
//                 }
                
//                 curr = curr.next(ch);
//             }
//         }
        
//         return cnt;
//     }
// }
// class GfG {
//     public static int countDistinctSubstring(String st) {
//         // your code here
//         Trie tr = new Trie();
        
//         return tr.countDistinct(st) + 1;
//     }
// }