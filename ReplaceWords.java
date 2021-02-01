//time complexity: O(m * n), m is length of sentence and n is length of word
//space complexity; O(mn)
/*
algorithm:
to build a trie for the words given in the dictionary list
for each word in sentence,
check if the word has prefix in trie and choose the shortest one.
once found, replace the original word with  dictionary word.

Return the new sentence.
*/
class TrieNode{
    String word;
    TrieNode[] children;
    boolean isEnd;
    
    TrieNode(){
        this.isEnd = false;
        this.word = word;
        this.children = new TrieNode[26];
    }
        
}
class Solution {
    TrieNode root;
    
    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0;i < word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
                
        }
        curr.isEnd = true;
        curr.word = word;
        
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        
        
        this.root = new TrieNode();
        
        for(String w : dictionary){
            insert(w);
        }
        
        String [] wordArray = sentence.split("\\s+");
        
        StringBuilder result = new StringBuilder();
        StringBuilder replaced;
        for(String word : wordArray){
            
            replaced = new StringBuilder();
            TrieNode curr = root;
            for(int i = 0; i < word.length();i++){
                char ch = word.charAt(i);
                if(curr.children [ch-'a'] == null || curr.isEnd) break;
                replaced.append(ch);
                curr = curr.children[ch-'a'];
            }
            if(curr.isEnd){
                result.append(replaced);
                result.append(" ");
            }else{
                result.append(word);
                result.append(" ");
            }
            
        }
            
        
        
        return result.toString().trim();
    }
}