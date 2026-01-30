import java.util.TreeMap;

class MyCalendarThree {

    TreeMap<Integer,Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        map.put(startTime,map.getOrDefault(startTime,0)+1);
        map.put(endTime,map.getOrDefault(endTime,0)-1);

        int max = 0;
        int val = 0;
        for(int x : map.values()){
            val += x;

            max = Math.max(max,val);
        }

        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */