import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
    private ArrayList<T> list;
    public Heap(){
        list = new ArrayList<>();
    }

    public int parent(int i){  // parent of 2 3 -> 1 that is 0
        return (i-1)/2;
    }

    public int left(int i){         //       1(0)
        return  2*i+1;               //     /    \
    }                               //    2(1)   3(2)

    public int right(int i){
        return 2*i+2;
    }

    public void insert(T x){
        list.add(x);
        upheap(list.size()-1);
    }

    private void upheap(int idx){
        if(idx == 0) return;
        
        int p = parent(idx);

        // child is smaller then parent
        if(list.get(idx).compareTo(list.get(p)) < 0){ 
            swap(idx, p);
            upheap(p);
        }  
    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Removing from an empty Heap");
        }
        T val = list.get(0);
        T last = list.get(list.size()-1);

        list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0,last);
        }

        downheap(0);
        return val;
    }

    private void downheap(int idx){
        int l = left(idx);
        int r = right(idx);
        
        int min = idx;
        if(l<list.size() && list.get(l).compareTo(list.get(min))<0){
            min = l;
        } 
        if(r<list.size() && list.get(r).compareTo(list.get(min))<0){
            min = r;
        }   

        if(min!=idx){
            swap(idx, min);
            downheap(min);
        }
    }

    public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> ans = new ArrayList<>();
        while(!list.isEmpty()){
            ans.add(this.remove());
        }
        return ans;
    }

    private void swap(int i , int j){
        T temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
}



class Main{
    public static void main(String[] args)  throws Exception{
        Heap<Integer> heap = new Heap<>();
        heap.insert(5);
        heap.insert(9);
        heap.insert(1);
        heap.insert(-5);
        heap.insert(-9);
        heap.insert(15);

        ArrayList<Integer> ans = heap.heapSort(); 
        System.out.println(ans);
    }
}
