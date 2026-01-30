class Integerection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();

        for(int f[] : firstList){
            list.add(new int[]{f[0],1});
            list.add(new int[]{f[1]+1,-1});
        }

        for(int s[] : secondList){
            list.add(new int[]{s[0],1});
            list.add(new int[]{s[1]+1,-1});
        }

        Collections.sort(list,(a,b)->{
            if(a[0] == b[0]) return a[1] - b[1];

            return a[0]-b[0];
        });

        List<int[]> ans = new ArrayList<>();
        int cnt = 0;
        for(int i=0 ; i<list.size() ; i++){

            int it[] = list.get(i);

            cnt += it[1];

            if(cnt == 2){
                ans.add(new int[]{it[0] , list.get(i+1)[0]-1});
            }
        }


        int ansArr[][] = new int[ans.size()][2];

        for(int i=0 ;i<ans.size() ; i++){
            ansArr[i] = ans.get(i);
        }


        return ansArr;

    }
}