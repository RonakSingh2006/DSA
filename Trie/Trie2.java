package Trie;

class Trie2 {
    class Node{
        Node arr[];
        boolean flag;
        int countPrefix;

        int endWith;

        Node(){
            arr = new Node[26];
            flag = false;
        }
    }

    Node root;
    public Trie2() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node curr = root;
        for(int i=0 ; i<word.length() ; i++){
            char ch = word.charAt(i);

            if(curr.arr[ch-'a'] == null){
                curr.arr[ch-'a'] = new Node();
            }

            curr = curr.arr[ch-'a'];
            curr.countPrefix++;
        }

        curr.flag = true;
        curr.endWith++;
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node curr = root;
        for(int i=0 ; i<word.length() ; i++){
            char ch = word.charAt(i);

            if(curr.arr[ch-'a'] == null) return 0;

            curr = curr.arr[ch-'a'];
        }

        if(curr == null || !curr.flag) return 0;

        return curr.endWith;

    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node curr = root;


        for(int i=0 ; i<word.length() ; i++){
            char ch = word.charAt(i);
            if(curr.arr[ch-'a'] == null) return 0;

            curr = curr.arr[ch-'a'];

        }

        return curr.countPrefix;
    }

    public void erase(String word) {
        // Write your code here.
        if(countWordsEqualTo(word) == 0) return;

        Node curr = root;
        
        for(int i=0 ; i<word.length() ; i++){
            char ch = word.charAt(i);

            curr = curr.arr[ch-'a'];
            curr.countPrefix--;
        }

        curr.endWith--;
        if(curr.endWith== 0){
            curr.flag = false;
        }
    }

}