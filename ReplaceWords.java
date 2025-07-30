// Time Complexity : O(len of string + n *len) where n = words in dictionary
// Space Complexity : O(n*l)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Add all words in dictionary to trie. For each word in sentence, check if there is a prefix in trie. If 
/// yes replace word in sentence with prefix. 

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder res=new StringBuilder("");
        Trie trie = new Trie();
        for(int i=0;i<dictionary.size();i++){
            trie.insert(dictionary.get(i));
        }
        String words[] = sentence.split(" ");
        for(int i=0;i<words.length;i++){
            String prefix = trie.getPrefix(words[i]);
            if(prefix.length()!=0){
                res.append(prefix);
            }
            else{
                res.append(words[i]);
            }
            res.append(" ");
        }
        res.setLength(res.length()-1);
        return res.toString();
    }
}
class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode children[];
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public String getPrefix(String word){
        TrieNode ptr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ptr.isEnd){
                return word.substring(0,i);
            }
            if(ptr.children[ch-'a']==null){
                return "";
            }
            ptr = ptr.children[ch-'a'];
        }
        return word;
    }
    public void insert(String word) {
        TrieNode ptr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ptr.children[ch-'a']==null){
                ptr.children[ch-'a'] = new TrieNode();
            }
            ptr = ptr.children[ch-'a'];
        }
        ptr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode ptr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ptr.children[ch-'a']==null){
                return false;
            }
            ptr = ptr.children[ch-'a'];
        }
        return ptr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode ptr = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(ptr.children[ch-'a']==null){
                return false;
            }
            ptr = ptr.children[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */