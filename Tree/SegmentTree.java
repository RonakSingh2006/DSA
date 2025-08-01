
public class SegmentTree{
    class Node{
        int data;
        Node left,right;
        int startInterval,endInterval;

        Node(int start , int end){
            this.startInterval = start;
            this.endInterval = end;
        }
    }

    Node root;

    SegmentTree( int arr[]){
        this.root = constructTree(arr, 0, arr.length-1);
    }

    // O(n)
    public Node constructTree(int arr[] , int start , int end){
        // leaf Node
        if(start == end){
            Node newNode = new Node(start, end);
            newNode.data = arr[start];
            return newNode;
        }

        Node newNode = new Node(start,end);

        int mid = start+(end - start)/2;
        newNode.left = constructTree(arr, start, mid);
        newNode.right = constructTree(arr, mid+1, end);


        newNode.data = newNode.left.data + newNode.right.data; 

        return newNode;
    }

    public void display(){
        display(root);
    }
    public void display(Node root){
        if(root == null) return;
        System.out.println("Interval ["+root.startInterval+","+root.endInterval+"] --> "+root.data);
        display(root.left);
        display(root.right);
    }

    // O(logn)
    public int query(int start , int end){
        return query(root , start, end);
    }
    public int query(Node root , int s , int e){
        // node lie inside interval completely
        if(root.startInterval >= s && root.endInterval <= e) return root.data;
        // completely outside
        else if(s > root.endInterval || e < root.startInterval) return 0;

        // overlap
        return query(root.left, s, e) + query(root.right, s, e);

    }

    // update
    //O(logn)
    public void set(int data , int index){
        root.data = set(root, data, index);
    }
    private int set(Node root , int data , int index){
        // lie inside interval
        if(index <= root.endInterval && index>= root.startInterval){
            // leaf Node
            if(root.startInterval == root.endInterval){
                root.data = data;
                return root.data;
            }
            else{
                int val = set(root.left, data, index) + set(root.right, data, index);
                root.data = val;
                return val;
            }
        }
        else return root.data;
    }


    public static void main(String[] args) {
        int arr[] = {1,2,3};
        SegmentTree tree = new SegmentTree(arr);
        tree.display();
        tree.set(5, 0);
        System.out.println();
        tree.display();
        System.out.println(tree.query(0, 2));
    }
}