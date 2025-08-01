// class Node{
//     Node arr[];

//     Node(){
//         arr = new Node[2];
//     }

//     public boolean contains(int x){
//         return arr[x] != null;
//     }

//     public void add(int x){
//         arr[x] = new Node();
//     }

//     public Node shift(int x){
//         return arr[x];
//     }
// }

// class Trie{
//     Node root;

//     Trie(){
//         root = new Node();
//     }

//     private int getBit(int num , int i){
//         int bitmask = (1<<(i-1));

//         return (num & bitmask) == 0 ? 0 : 1;
//     }

//     public void insert(int num){
//         Node curr = root;
//         for(int i=32 ; i>=1 ; i--){

//             int bit = getBit(num,i);

//             if(!curr.contains(bit)){
//                 curr.add(bit);
//             }

//             curr = curr.shift(bit);
            
//         }
//     }


//     public int maxXOR(int num){
//         Node curr = root;

//         int ans = 0;
//         for(int i=32 ; i>=1 ; i--){

//             int bit = getBit(num,i);

//             int opsBit = bit^1;

//             if(curr.contains(opsBit)){
//                 ans =  ans | (1<<(i-1));

//                 curr = curr.shift(opsBit);
//             }
//             else curr = curr.shift(bit);
            
//         }

//         return ans;
//     }
// }
// class Solution {
//     public static int findMaximumXOR(int[] nums) {
//         Trie tr = new Trie();

//         for(int x : nums){
//             tr.insert(x);
//         }


//         int max = Integer.MIN_VALUE;

//         for(int x : nums){
//             max = Math.max(max,tr.maxXOR(x));
//         }

//         return max;
//     }
//     public static void main(String[] args) {
//         int arr[] = {1,2,3};
//         System.out.println(findMaximumXOR(arr));
//     }
// }