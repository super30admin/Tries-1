\class Solution {
    
    class TrieNode {
        boolean isWord;
        String str;
        TrieNode[] children;
        
        public TrieNode(){
            isWord = false;
            str = "";
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public String replaceWords(List<String> dict, String sentence) {
        
        root = new TrieNode();
        
        // create Trie with dic
        create_trie(dict);
        
        String[] str = sentence.split(" ");
        
        String ret_val = "";
        
        for (String w : str){
            
            ret_val += new_str(w) + " ";
        }
        
        return ret_val.substring(0,ret_val.length() - 1);
    }
    
    private String new_str(String str){
        TrieNode node = root;
        
        for (int x = 0; x < str.length(); x++){
            
            Character ch = str.charAt(x);
            
            if (node.isWord == true){
                return node.str;
            }
            
            if (node.children[ch -'a'] == null){
                break;
            } else {
                node = node.children[ch -'a'];
            }
            
        }
        
        return str;
    }
    
    private void create_trie(List<String> dict){
        
        
        for (String word : dict){
            TrieNode node = root;
            
            for (int x = 0; x < word.length(); x++){
                 Character ch = word.charAt(x);
                if (node.children[ch - 'a'] == null){
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
           node.isWord = true;
           node.str = word; 
        }
    }
}