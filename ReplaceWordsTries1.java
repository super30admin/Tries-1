class Solution {
    TrieNode root;
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
       
        public TrieNode(){
            children = new TrieNode[26];
        }
    }  
        public void insert(String word){
            TrieNode curr = root;
            for(int i = 0 ;i < word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null ){
                   curr.children[c - 'a'] = new TrieNode();
                }
                 curr = curr.children[c- 'a'];
            }
            curr.isEnd = true;
        }
   
   
    public String replaceWords(List<String> dict, String sentence) {
         root = new TrieNode();
        for(String dictionary : dict){
            insert(dictionary);
        }
       
        String[] sentenceArr = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        for(int k = 0 ;k <sentenceArr.length;k++){
            String word = sentenceArr[k];
            if(k > 0 ) result.append(" ");
            StringBuilder replStr = new StringBuilder();
            TrieNode curr = root;
            for(int i = 0 ;i < word.length() ; i++){
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null || curr.isEnd ) break;  //dont go further once found the shorter replacement or when THE not found in dic
                replStr.append(c);
                curr = curr.children[c - 'a'];
            }  // after word end check
                if(curr.isEnd ){
                    result.append(replStr); // replaced word
                }
                else{
                    result.append(word);    /// not found then the as is word
                }
           
            }
        return result.toString();
        }
}
/*
Time complexity: n words in dictionary and average length is L ,sentence has m words and average length is L then
O(mL + nL)
Space complexity:Trie space is used for computation O(nL) where n is no of words inserted with average length L
*/

