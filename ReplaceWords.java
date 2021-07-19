// Time Complexity: O(N) where N is the length of the sentence
// Space Complexity: O(N) Size of trie
// Run on leetcode: yes
// Issues faced: need practice building and fetching the trie. Made too many silly mistakes and spent too much time correcting them.

class TrieNode{
    boolean isEnd;
    TrieNode[] children;
    public TrieNode(){
        this.children = new TrieNode[26];
    }
}
class Solution {
    TrieNode root;
    public void trieBuilding(List<String> dictionary){
        for(String str: dictionary){
            TrieNode curr = root;
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if(curr.children[c-'a'] == null){
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true;
        }
    }
    
    public String trieFetch(String word){
        TrieNode curr = root;
        StringBuilder str = new StringBuilder();
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) return word;
            else if(curr.children[c-'a'] != null){
                str.append(c);
                if(curr.children[c-'a'].isEnd == true)
                    return str.toString();
            }
            curr = curr.children[c-'a'];
        }
        return word;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        trieBuilding(dictionary);
        StringBuilder s = new StringBuilder();
        for(String word: sentence.split("\\s+")){
            String temp = trieFetch(word);
            s.append(temp);
            s.append(" ");   
        }
        return s.toString().trim();
    }
}
