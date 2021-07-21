// Time Complexity: O(NxL) where L is the length of the longest string and N is the number of Strings in the words dictionary
// Space Complexity: O(NxL)
// Run on Leetcode: Yes
// Issues faced: None

class TrieNode{
    String word = "";
    boolean isEnd;
    TrieNode[] children;
    TrieNode(){
        this.children = new TrieNode[26];
    }
}
class Solution {
    TrieNode root;
    private void TrieBuilder(String[] words){
        for(String str: words){
            TrieNode curr = root;
            StringBuilder s = new StringBuilder();
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                s.append(c);
                if(curr.children[c-'a'] == null){
                    curr.children[c-'a'] = new TrieNode();
                    curr.children[c-'a'].word = new String(s.toString());
                }
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true;
        }
    }
    public String longestWord(String[] words) {
        root = new TrieNode();
        TrieBuilder(words);
        Queue<TrieNode> q = new LinkedList<>();
        TrieNode curr = root;
        q.add(curr);
        while(!q.isEmpty()){
            TrieNode t = q.poll();
            curr = t;
            for(int i=25; i>=0; i--){
                if(t.children[i] != null && t.children[i].isEnd == true){
                    q.add(t.children[i]);
                }
            }
        }
        return curr.word;
    }
}
