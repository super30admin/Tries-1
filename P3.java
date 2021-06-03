//time- o(n*L)+O(N)-> n-no of words in dict- L avg length of words, N-no of chars in sentence
//space- o(n*L)
class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode()
        {
         children = new TrieNode[26];   
        }
    }
    TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        
        //Build Trie
        for(String word: dictionary)
        {
            TrieNode cur=root;
            for(char c: word.toCharArray())
            {
                 if(cur.children[c-'a'] == null)
                 {
                    cur.children[c-'a'] = new TrieNode();
                 }
                 cur = cur.children[c-'a'];           
            }
                cur.isEnd= true; 
        }
        
        String[] words = sentence.split("\\s+");//if it has multiple spaces
        StringBuilder result = new StringBuilder();
        StringBuilder sb;
        
        //Iterate through words in the sentence
        for(String word: words)
        {   
            sb = new StringBuilder();
            TrieNode cur=root;            
            //Iterate through letters in the word
            for(char c: word.toCharArray())
            {
                 if(cur.isEnd || cur.children[c-'a'] == null) //if prefix has reached end and if word not in dictionary
                 {
                     break;                                    
                 }                 
                 sb.append(c); 
                 cur = cur.children[c-'a'];             
            }
            if(!cur.isEnd) {
                result.append(word); 
            }
            else {
                result.append(sb);
            }
            result.append(" ");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
}