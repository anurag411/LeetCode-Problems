class Solution {
    HashMap <Character, char []> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return result;
        
        map.put('2', "abc".toCharArray());
        map.put('3', "def".toCharArray());
        map.put('4', "ghi".toCharArray());
        map.put('5', "jkl".toCharArray());
        map.put('6', "mno".toCharArray());
        map.put('7', "pqrs".toCharArray());
        map.put('8', "tuv".toCharArray());
        map.put('9', "wxyz".toCharArray());
        
        char ch [] = digits.toCharArray();
        StringBuilder str = new StringBuilder();
        allCombinations(ch, 0, str);
        
        return result;
        
    }
    
    
    public void allCombinations(char ch[], int index, StringBuilder output) {
        if(index == ch.length) {
            result.add(output.toString());
            return ;
        }
        char temp[] = map.get(ch[index++]); 
        for(int i=0;i<temp.length;i++) {
            StringBuilder str = new StringBuilder();
            str.append(output);
            str.append(Character.toString(temp[i]));
            allCombinations(ch, index, str);
        }
    }
}
