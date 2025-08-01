package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Alien {
    // Time : O(n2) Space : O(2n)
    public static List<Character> getNodes(String[] words){
        HashSet<Character> set = new HashSet<>();
        for(String s : words){
            for(int i=0 ; i<s.length() ; i++){
                set.add(s.charAt(i));
            }
        }
        
        List<Character> list = new ArrayList<>();
        for(char x : set){
            list.add(x);
        }
        
        return list;
        
    }
    
    // Time : O(n) Space : O(1)
    public static char[] order(String a , String b){
        int i=0,j=0;
        
        while(i<a.length() && j<b.length() && a.charAt(i) == b.charAt(j)){
            i++;
            j++;
        }
        if(i==a.length() || j==b.length()) return null;
        return new char[]{a.charAt(i),b.charAt(j)};
    }
    
    // Time O(n2) Space : O(2n)
    public static List<char[]> getEdges(String[] words){
        int n = words.length;
        HashSet<String> set = new HashSet<>();
        List<char[]> edges = new ArrayList<>();

        for(int i=0 ; i<n-1 ; i++){
            if(words[i].length() > words[i+1].length() && words[i].startsWith(words[i+1])) return null;
            char[] arr = order(words[i],words[i+1]);
            if(arr!=null){
                String key = arr[0]+"#"+arr[1];
                if(!set.contains(key)){
                    edges.add(arr);
                    set.add(key);
                }
            }
        }
        
        return edges;
    }
    
    // Time O(n) Space O(n)
    public static HashMap<Character,List<Character>> adjList(List<Character> nodes , List<char[]> edges){
        HashMap<Character,List<Character>> adj = new HashMap<>();
        for(char x : nodes){
            adj.put(x,new ArrayList<>());
        }
        
        for(char[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
        }
        
        return adj;
    }
    
    // Time O(n3)
    public static String findOrder(String[] words) {
        // code here
        List<Character> nodes = getNodes(words);
        List<char[]> edges = getEdges(words);
        if(edges == null) return "";
        HashMap<Character,List<Character>> adj = adjList(nodes,edges);
        
        HashMap<Character,Integer> indeg = new HashMap<>();

        for(char x : nodes){
            indeg.put(x,0);
        }
        
        for(char[] arr : edges){
            indeg.put(arr[1],indeg.get(arr[1])+1);
        }
        
        Queue<Character> q = new LinkedList<>();
        
        for(Map.Entry<Character,Integer> e : indeg.entrySet()){
            if(e.getValue()==0){
                q.offer(e.getKey());
            }
        }
        
        
        
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char node = q.poll();
            
            for(char x : adj.get(node)){
                indeg.put(x,indeg.get(x)-1);
                if(indeg.get(x) == 0){
                    q.offer(x);
                }
            }
            
            sb.append(node);
        }
        
        if(sb.length() != nodes.size()) return "";
        
        return sb.toString();
        
    }
    public static void main(String[] args) {
        String words[] = {"abc","ab"};
        System.out.println(findOrder(words));
        
    }
}