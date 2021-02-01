
/*
set ans = ""
use hashset to  have O(1) lookuo time for prefix and add all teh words in it

iterrate the string array,
for every string :
    set flag = true;
    check every prefix of this string is present in set. If not, then set flag = false and break else continue.
    After iteratingt though current string, if flag is true, then update the result;


time complexity: O(words.length x words[i].length) -> O(N x n)
space complexity: O(N), no. of words in string array

*/
class LongestWord {
    public String longestWord(String[] words) {
        
        String ans = "";
        
        HashSet<String> set = new HashSet<>();
        for(String w: words){
            set.add(w);
        }
        
        
        
        for(int i = 0; i < words.length;i++){
            String currWord = words[i];
            boolean flag = true;
            for(int j = 1; j < currWord.length();j++){
                if(!set.contains(currWord.substring(0,j))){
                    flag = false;
                    break;
                     
                }
            }
            if(flag){
                if (currWord.length() > ans.length() || currWord.length() == ans.length() && currWord.compareTo(ans) < 0)
                {
                         ans = currWord;
                }
            }
            
        }
        
        
        return ans;
        
    }
}