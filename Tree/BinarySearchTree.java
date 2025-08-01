import java.util.ArrayList;
import java.util.List;


public class BinarySearchTree{


    class Node{

        Node left,right;
        int val,height;

        Node(int x){
            this.val = x;
            this.height = 0;
            left = right = null;
        }

    }
    
    // Root Node
    Node root;

    // Height
    public int getHeight(){
        return getHeight(root);
    }
    private int getHeight(Node root){
        if(root == null) return -1;
        return root.height;
    }


    // Add new Node
    public void add(int x){
        root = add(x,root);
    }

    private Node add(int x , Node root){
        if(root == null){
            return new Node(x);  
        }
        if(root.val < x) root.right = add(x,root.right);
        else root.left = add(x,root.left);

        root.height = Math.max(getHeight(root.left),getHeight(root.right))+1;
        return root;
    }

    // Balanced tree
    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(Node root){
        if(root == null) return true;
        return Math.abs(getHeight(root.left)-getHeight(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // Popualte
    public void populate(int arr[]){
        for(int x  : arr){
            this.add(x);
        }
    }

    // Dispaly
    public void display(){
        display(root , "Root Node : ");
    }
    private void display(Node root , String str){
        if(root == null) return;
        System.out.println(str + root.val);
        display(root.left,"Left Node of "+root.val+" : ");
        display(root.right,"Right Node of "+root.val+" : ");
    }
    public List<Integer> paths(){
        return paths(root,0);
    }
    private List<Integer> paths(Node root , int p){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        if(root.left == null && root.right == null){
            p = p*10 + root.val;
            list.add(p);
            return list;
        }
        p = p*10 + root.val;
        list.addAll(paths(root.left,p));
        list.addAll(paths(root.right,p));

        return list;
    }

    // inOrder traversal
    public List<Integer> inOrder(){
        return inOrder(root);
    }
    private List<Integer> inOrder(Node root){
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        list.addAll(inOrder(root.left));
        list.add(root.val);
        list.addAll(inOrder(root.right));
        return list;
    }
    
    // construct
    public void construct(List<Integer> list){
        root = helper(list);
    }
    private Node helper(List<Integer> list){
        if(list.isEmpty()) return null;
        if(list.size()==1) return new Node(list.get(0));
        int mid = list.size()/2;
        Node root = new Node(list.get(mid));
        root.left = helper(list.subList(0,mid));
        root.right = helper(list.subList(mid+1,list.size()));
        return root;
    }

    public static void main(String[] args) {
        // int arr[] = {23 ,-34 ,-87 ,-50 ,-12 ,15 ,67 ,42 ,99}; 
        // // int arr[] = {2,1,3};
        BinarySearchTree tree = new BinarySearchTree();
        // tree.populate(arr);
        /*  // prorder 23 -34 -87 -50 -12 67 42 15 99
         *              23
         *           /      \  
         *        -34        67
         *       /    \      /  \
         *    -87     -12  42    99
         *        \       /
         *        -50    15
         */
        // tree.display();
        // System.out.println("Height of tree is " + tree.getHeight());
        // System.out.println(tree.isBalanced());
        tree.populate(new int[]{1,2,3,4});
        //    1
        //     \
        //      2
        //       \
        //        3
        //         \
        //          4
        // tree.display();
        // System.out.println(tree.inOrder());

        

        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.construct(tree.inOrder());
        tree2.display();

    }
}