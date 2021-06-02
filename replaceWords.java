class Solution {
   
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    TrieNode root;
    
    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence){
        root = new TrieNode();
        for(String word : dictionary){
            insert(word);
        }
        String [] Str = sentence.split("\\s+"); // {"the", "cattle", "was", ....}
        StringBuilder result = new StringBuilder();
        StringBuilder interChange;
        TrieNode curr;
        for(int i = 0; i < Str.length; i++){
            if(i > 0){
                result.append(" ");
            }
            interChange = new StringBuilder();
            curr = root;
            String word = Str[i];
            for(int j = 0; j < word.length(); j++){
                char c = word.charAt(j);
                if(curr.children[c - 'a'] == null || curr.isEnd == true)break;
                curr = curr.children[c - 'a'];
                interChange.append(c);
            }    
            //add to the result only if we find the replacement word in dictionary
            if(curr.isEnd){
                result.append(interChange.toString());
            }else // add the orignal word
            {
                result.append(word);
            }
        }
        return result.toString();
        
    }
}
