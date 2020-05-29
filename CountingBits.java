class Solution {
    
    public int[] countBits(int num) {
        int arr[] = new int[num+1];
        if(num == 0)
            return arr;
        arr[0] = 0;
        arr[1] = 1;
        if(num == 1)
            return arr;
        int index =1;
        for(int i=2;i<=num;i++) {
            if((index*2) == i) {
                arr[i] = 1;
                index =1;
            } else {
                arr[i] = arr[index++] +1;
            }
        }
        return arr;
    }
}
