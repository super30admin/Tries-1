// Time Complexity : insert O(m*n) n - length of word, m - length of sentence
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        String[] splited = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s: dictionary){
            insert(s);
        }
        for(int i = 0;i<splited.length;i++){
            String temp = getPrefixOrDefault(splited[i]);
            sb.append(temp);
            if(i == splited.length-1) continue;
            sb.append(" ");
        }
        return sb.toString();

    }
    public void insert(String word){
        TrieNode current = root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(!current.children.containsKey(c)){
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.eof = true;
    }

    public String getPrefixOrDefault(String word){
        StringBuilder res = new StringBuilder();
        TrieNode current = root;
        for(int i = 0; i<word.length();i++){
            char c = word.charAt(i);
            if(current.eof) return word.substring(0,i);
            if(!current.children.containsKey(c)){
                if(current.eof){
                    return word.substring(0,i);
                }
                return word;
            }
            res.append(c);
            current = current.children.get(c);
        }
        if(current.eof) return res.toString();
        return word;
    }
}
class TrieNode{
    Map<Character, TrieNode> children;
    boolean eof;
    TrieNode(){
        children = new HashMap<>();
        eof = false;
    }
}