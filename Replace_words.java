class Solution {
    class TrieNode{
        TrieNode [] children;
        
        boolean isEnd;
        
        public TrieNode(){
            this.children = new TrieNode[26];
        }
        
    }
        
    TrieNode root;
    private void insert(String word){
        TrieNode curr  = root;
        for(int i = 0; i < word.length(); i++){
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
        
        //inserting all words of dict
        for(String word: dictionary){ //nL
            insert(word);
        }
        String [] splitArr = sentence.split("\\s+"); //['the', 'cattle', 'were']
        StringBuilder result = new StringBuilder();
        StringBuilder replacement;
        TrieNode curr;
        for(int k = 0; k < splitArr.length; k++){ //N
            String word = splitArr[k];
            replacement = new StringBuilder();
            
            if(k > 0){
                result.append(" ");
            }
            
            
            curr = root;
            for(int i= 0 ; i < word.length(); i++){
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null || curr.isEnd) break;
                curr = curr.children[c - 'a'];
                replacement.append(c);
            }
            if(curr.isEnd){
                result.append(replacement.toString());
            } else{
                result.append(word);
            }
        }
        return result.toString();
    }
}

//TC nL -> for building the string
// O(N) appending to result
