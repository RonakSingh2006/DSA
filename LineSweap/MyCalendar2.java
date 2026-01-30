import java.util.TreeMap;

class MyCalendarTwo {

    TreeMap<Integer,Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        map.put(startTime,map.getOrDefault(startTime,0)+1);
        map.put(endTime,map.getOrDefault(endTime,0)-1);

        int val = 0;
        for(int x : map.values()){
            val += x;

            if(val > 2) break;
        }

        if(val > 2){
            map.put(startTime,map.getOrDefault(startTime,0)-1);
            map.put(endTime,map.getOrDefault(endTime,0)+1);
            return false;
        }

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */