class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n==0)
            return result;
        String str = "";
        str = str.concat("(");
        printParenthesis(n-1, str, n); 
        return result;       
    }
    
    public void printParenthesis(int n, String str, int m) {
        if(n==0) {
            while(m > 0) {
                str = str.concat(")");
                m--;
            }
            result.add(str);
            return ;
        }
        String str1 = str;
        str1 = str1.concat("(");
        str = str.concat(")");
        printParenthesis(n-1, str1, m);
        if(m > n)
            printParenthesis(n, str, m-1);
    }
}
