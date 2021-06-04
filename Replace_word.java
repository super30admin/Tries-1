/*Running Time Complexity: O(nl)
Space Complexity: Constant or O(1)
Successfully Run and Compiled on leetcode

*/
class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean the_End;
        public TrieNode(){
            this.children = new TrieNode[26];
            
        }
    }
    TrieNode root;
    List<String> result = new ArrayList<String>();
    private void insert(String word){
            TrieNode curr = root;
            for(int i = 0;i<word.length();i++){
                char c = word.charAt(i);
                if (curr.children[c -'a']==null){
                    curr.children[c -'a'] = new TrieNode();
                }
                    curr = curr.children[c-'a'];
            }
        curr.the_End = true;
        }
       
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String word: dictionary){
            insert(word);
        }
        String[] splitarr = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        StringBuilder replacement;
        TrieNode curr;
        for(int k = 0;k<splitarr.length;k++){
            String word = splitarr[k];
            replacement = new StringBuilder();
            
            if(k>0){
                result.append(" ");
            }
            curr = root;
            for(int i = 0;i<word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c-'a']==null || curr.the_End) break;
                curr = curr.children[c-'a'];
                replacement.append(c);
                
            }
            if(curr.the_End==true){
                result.append(replacement.toString());
            }
            else{
                result.append(word);
            }
            
        }
      
    return result.toString();
    }
}