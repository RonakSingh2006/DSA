package LineSweap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MettingRoom {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        
        List<int[]> list = new ArrayList<>();
        
        for(int x : start){
            list.add(new int[]{x,1});
        }
        
        for(int x : end){
            list.add(new int[]{x,-1});
        }
        
        Collections.sort(list,(a,b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            
            return a[0] - b[0];
        });
        
        
        int ans = 0;
        int cnt = 0;
        
        for(int[] a : list){
            cnt += a[1];
            
            ans = Math.max(ans,cnt);
        }
        
        return ans;
        
    }
}
