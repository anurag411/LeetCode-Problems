class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int ch[] = new int[26];
        for(char c : tasks)
            ch[c-'A']++;
        Arrays.sort(ch);
        int max = ch[25]-1;
        int emptySlots = max*n;
        for(int i=24;i>=0 && ch[i] > 0 ;i--) {
            emptySlots = emptySlots - Math.min(max, ch[i]);
            if(emptySlots <= 0)
                break;
        }
        return emptySlots > 0 ? emptySlots + tasks.length : tasks.length;
    }
}
