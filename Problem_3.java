// Time complexity - O(Insertion + Replacement) , number of words* avg length of words
// Space complexity - O(mn), m = number of words in dictionary, n = avg length of strings


class Solution {
    TrieNode root;
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        root = new TrieNode();
        for(String s : dict){
            insert(s);
        }
        
        String[] sentenceArray = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        for(int k = 0; k < sentenceArray.length; k++){
            String s = sentenceArray[k];
            if(k > 0) result.append(" ");
            TrieNode curr = root;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(curr.children[c-'a'] == null || curr.isEnd) break;
                sb.append(c);
                curr = curr.children[c-'a'];
            }
            
            if(curr.isEnd){
                result.append(sb);
            }else{
                result.append(s);
            }
        }
        return result.toString();
    }
}
