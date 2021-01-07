class Solution {
    class TrieNode{
        boolean IsEnd;
        TrieNode [] Children;
        
        public TrieNode(){
            Children = new TrieNode[26];
        }  
    }
    TrieNode root;
    
    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.Children[c - 'a'] == null){
                curr.Children[c - 'a'] = new TrieNode();
            }
            curr = curr.Children[c - 'a'];
        }
        curr.IsEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String s : dictionary){
            insert(s);
        }
        StringBuilder result = new StringBuilder();
        String[] input = sentence.split("\\s+");
        TrieNode curr;
        for(int i = 0; i < input.length; i++){
            if(i > 0){
                result.append(" ");
            }
            String s = input[i];
            curr = root;   
            StringBuilder replacement = new StringBuilder();
            for(int j = 0; j < s.length(); j++){  
                char c = s.charAt(j);
                if(curr.Children[c - 'a'] == null || curr.IsEnd){
                    break;
                }
                replacement.append(c);
                curr = curr.Children[c - 'a'];
                    
            }
            if(curr.IsEnd){
                result.append(replacement);
            }else{
                result.append(s);
            }
        }
        
        return result.toString();
    }
}
