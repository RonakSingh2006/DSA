public class AVL{
    class Node{

        Node left,right;
        int val,height;

        Node(int x){
            this.val = x;
            left = right = null;
            height = 0;
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

        return rotate(root);
    }

    public Node rotate(Node root){
        if(root == null) return root;
        
        // left side is unbalanced
        if(getHeight(root.left)-getHeight(root.right) > 1){
            // LL rotation
            if(getHeight(root.left.left)-getHeight(root.left.right) > 0){
                root = rightRotate(root);
            }
            // LR
            else if(getHeight(root.left.left)-getHeight(root.left.right) < 0){
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        }

        // right  side is unbalanced
        if(getHeight(root.right)-getHeight(root.left) > 1){
            // RR rotation
            if(getHeight(root.right.right)-getHeight(root.right.left) > 0){
                root = leftRotate(root);
            }
            // RL
            else if(getHeight(root.right.right)-getHeight(root.right.left)  < 0){
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
        }

        return root;

    }
    public Node leftRotate(Node root){
        Node t1 = root.right;
        Node t2 = t1.left;
        t1.left = root;
        root.right = t2;

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        t1.height = Math.max(getHeight(t1.left), getHeight(t1.right)) + 1;
        return t1;
    }
    public Node rightRotate(Node root){
        Node t1 = root.left;
        Node t2 = t1.right;
        t1.right = root;
        root.left = t2;

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        t1.height = Math.max(getHeight(t1.left), getHeight(t1.right)) + 1;
        return t1;
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
    
    

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}; 
        AVL tree = new AVL();
        tree.populate(arr);
        tree.display();
        System.out.println("Height of tree is " +tree.getHeight());
        System.out.println(tree.isBalanced());
        
    }
}