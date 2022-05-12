/* 
TC 
insertion TC O(nl) where n is the number of words and l average length of word
search = O(ml) m is number of search words and l average length of word

TC insert : 

SC O(nl)  where n is the number of words and l average length of word

Applications: IP routing(prefix matching) n AutoComplete n Spell Checker n solving word games 

*/
class Trie {
    
    class TrieNode{
        boolean isEnd;
        TrieNode [] list;
        public TrieNode(){
            isEnd = false; 
            list = new TrieNode[26]; 
        }
        
    }
    
    TrieNode root; 

    public Trie() {
        root = new TrieNode();
        
    }
    
    public void insert(String word) {
        TrieNode temp = root; 
        for (int i=0; i < word.length(); i++){
            //c = word.charAt(i);
            int t = word.charAt(i) - 'a';
            if(temp.list[t] == null){
                temp.list[t]  = new TrieNode();
            }
            temp = temp.list[t];
            
        }
        temp.isEnd = true; 
        
    }
    
    public boolean search(String word) {
        TrieNode temp = root; 
        for (int i= 0; i < word.length(); i++){
            int t = word.charAt(i) - 'a';
            if(temp.list[t] == null) return false;
            temp = temp.list[t];
            
        }
        return temp.isEnd; 
        
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp = root; 
        for (int i= 0; i < prefix.length(); i++){
            int t = prefix.charAt(i) - 'a';
            
            if(temp.list[t] == null) return false;
            temp = temp.list[t];
            
        }
        return true;
        
    }
}
