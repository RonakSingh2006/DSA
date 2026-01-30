import java.util.TreeMap;

class MyCalendar {

    TreeMap<Integer,Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        Integer prevVal = map.lowerKey(endTime);

        if(prevVal != null && startTime < map.get(prevVal) ){
            return false;
        }

        map.put(startTime,endTime);

        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */