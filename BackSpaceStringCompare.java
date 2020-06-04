class Solution {
    public boolean backspaceCompare(String S, String T) {
        
        return isSame(S, T);
    }
    public static Boolean isSame(String s, String t) {
        char ch[] = new char[s.length()];
        int index_ch = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#' && i > 0) {
                if(index_ch >0)
                    index_ch--;
            } else if(s.charAt(i) != '#'){
                ch[index_ch++] = s.charAt(i);
            }
        }
        int count = 0;
        for (int i = t.length()-1; i>=0 ; i--) {
            if (t.charAt(i) == '#') {
                    count++;
            } else if(count == 0 && index_ch >0 && t.charAt(i) == ch[index_ch-1]) {
                index_ch--;
            } else if(count == 0 && index_ch >0 && t.charAt(i) != ch[index_ch-1]){
                return false;
            } else if(count == 0 && index_ch == 0)
                return false;
            else {
                count--;
            }
        }
        if(index_ch > 0)
            return false;
        return true;
    }
}
