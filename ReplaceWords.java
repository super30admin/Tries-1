// Time Complexity : O(n) n is the total charcters in the dictionary words and the input string 
// Space Complexity : O(n) n is the total charcters in the dictionary words and the input string 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class ReplaceWords {
    
    class Trie{
        Trie[] children = new Trie[26];
        boolean isWord;
        String word;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        for(String word : dictionary){
            Trie node = root;
            for(char c  : word.toCharArray()){
                if(node.children[c-'a'] == null) node.children[c-'a'] = new Trie();
                node =node.children[c-'a'];
            }
            node.isWord = true;
            node.word = word;
        }
        
        StringBuilder sb = new StringBuilder();
        for(String word : sentence.split(" ")){
            Trie node = root;
            for(char c  : word.toCharArray()){
                if(node.children[c-'a'] == null){
                    sb.append(word).append(" ");
                    node = null;
                    break;
                }
                else if(node.children[c-'a'].isWord){
                    sb.append(node.children[c-'a'].word).append(" ");
                    node = null;
                    break;
                }else{
                    node = node.children[c-'a'];
                }
            }
            if(node != null && !node.isWord) sb.append(word).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}