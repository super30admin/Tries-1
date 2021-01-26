// Time Complexity : O(N) where N is the length of the sentence
// Space Complexity : O(N), for trie, stringbuilder to form result

// Your code here along with comments explaining your approach
// form trie, split string acc to words, lookup prefix for each word, form result

class TrieNode{
    Map<Character, TrieNode> children;
    boolean isEnd;
    
    public TrieNode(){
        this.children = new HashMap<>();
    }
}

class Trie {
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie(List<String> dictionary) {
        this.root = new TrieNode();
        
        for(String word : dictionary){
            this.insert(word);
        }
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        
        for(char ch : word.toCharArray()){
            if(!cur.children.containsKey(ch)){
                cur.children.put(ch, new TrieNode());
            }
            
            cur = cur.children.get(ch);    
        }
        
        cur.isEnd = true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public String getWordPrefix(String word) {
        TrieNode cur = root;
        StringBuilder sb = new StringBuilder();
        
        for(char ch : word.toCharArray()){
            if(cur.isEnd){
                return sb.toString();
            }
            if(!cur.children.containsKey(ch)){
                return word; 
            }

            sb.append(ch);
            cur = cur.children.get(ch);
        }
        
        return word;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie(dictionary);
        String[] parts = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for(String part : parts){
            result.append(trie.getWordPrefix(part));    
            result.append(" ");
        }
        
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
}
