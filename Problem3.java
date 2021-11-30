//leetcode 648: Replace words
// time - O(n)
// space - O(n*k)

class Solution {
    
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    
    public void insert(String word){
        
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i ++){
            char c = word.charAt(i);
                
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        
        root = new TrieNode();
        
        for(String word: dictionary){
            insert(word);
        }
        
        String[] sentenceArray = sentence.split(" ");
        StringBuilder replacement = new StringBuilder();
        
        for (String word: sentenceArray){
            
            StringBuilder temp = new StringBuilder();
            TrieNode curr = root;
            
            for(int i = 0; i < word.length(); i++ ){
                
                char c = word.charAt(i);
                
                
                if((curr.children[c - 'a'] == null) || curr.isEnd == true){
                    break;
                }
                temp = temp.append(c);

                curr = curr.children[c - 'a'];
            }
            
            if(curr.isEnd){
                replacement.append(temp + " ");
            }else{
                replacement.append(word + " ");
            }
        }
        
        return replacement.toString().trim();
    }
}