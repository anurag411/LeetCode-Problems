class Solution {
   
    boolean[] visited;
    public boolean wordBreak(String s, List<String> wordDict) {
         
        visited = new boolean[s.length()];
        return searchWords(wordDict, s, 0);
    }
    
    private boolean searchWords(List<String> wordDict, String str, int index){         
        if(index == str.length()) return true;
        
        // if already visited then no need check because we already have that result
        if(visited[index]) return false;
        visited[index] = true;
        
        // running loop for each word and check is it find in string from index which is given
        for(String word : wordDict){
            if(str.startsWith(word, index) && searchWords(wordDict, str, index+word.length()))
                return true;
        }
        return false;
    }
}
