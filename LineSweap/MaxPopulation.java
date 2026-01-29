package LineSweap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxPopulation {
    public int maximumPopulation(int[][] logs) {
        List<int[]> list = new ArrayList<>();

        for(int[] it : logs){
            list.add(new int[]{it[0],1});
            list.add(new int[]{it[1] , -1});
        }

        Collections.sort(list,(a,b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            
            return a[0]-b[0];
        });

        int ans = 0;
        int maxPop = 0;
        int pop = 0;

        for(int[] it : list){
            pop += it[1];

            if(pop > maxPop){
                maxPop = pop;
                ans = it[0];
            }
        }

        return ans;
    }
}