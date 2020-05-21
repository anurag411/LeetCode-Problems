class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals.length == 1)
            return intervals;
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int j =0;
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i][0] <= intervals[j][1]) {
                if(intervals[i][1] > intervals[j][1]) {
                    intervals[j][1] = intervals[i][1];
                } 
            } else {
                j++;
                intervals[j][0] = intervals[i][0];
                intervals[j][1] = intervals[i][1];
            }
        } 
        int arr[][] = new int[j+1][2];
        for(int i=0;i<j+1;i++) {
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
        }
        return arr;
    }
    
}
