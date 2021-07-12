/* TC, SC O(N) - length of the sentence
 * */


class TrieNode{
    boolean isEnd; 
    TrieNode[] children;
    public TrieNode(){
        this.children = new TrieNode[26];
    }
}

class Solution {
    TrieNode root = new TrieNode();
    public void insert(String word){
        TrieNode curr = root; 
        for (int i = 0 ; i < word.length(); i++){
            char ch = word.charAt(i);
            if (curr.children[ch-'a'] == null){
                TrieNode node = new TrieNode();
                curr.children[ch-'a'] = node;
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd= true;
    }
    
    public StringBuilder startsWith(String word){
         TrieNode curr = root;
         StringBuilder small= new StringBuilder();
         for (int i = 0 ; i < word.length(); i++){
          char   ch = word.charAt(i);
             // if no character is present or we have reached the smallest prefix
            if (curr.children[ch-'a'] == null || curr.isEnd) break;
             small.append(ch);
             curr = curr.children[ch-'a'];
        }
        // there isn't any smaller prefix
        if (curr.isEnd != true ) return null;
        return small;
    }  
    public String replaceWords(List<String> dictionary, String sentence) {
        
        //1 . create a trie prefix tree 
        // 2. check if the word in senence starts with any of the sequence in prefix tree,if yes, replace, else retain the word as is 
        
        for (String word: dictionary){
            insert(word);
        }
        
        // split the sentence to list of words
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < words.length; i++){
            if (i > 0) sb.append(" ");
            String myWord = words[i];
            StringBuilder smaller  = startsWith(myWord) ;
            if (smaller != null ){
                // if there exists a smaller prefix, add the prefix
                sb.append(smaller);
            } else {
                // retain the word as is
                sb.append(myWord);
            }           
        }
        return sb.toString();
    }   

}


