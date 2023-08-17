// Time Complexity : O(n*l)
// Space Complexity : O(n*l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    //Using trie to store the words
    class Trie{
        Trie[] children;
        boolean isEnd;
        public Trie(){
            children = new Trie[26];
            this.isEnd = false;
        }
    }

    Trie head;
    String result = "";
    //Insert function to insert the word in trie
    private void insert(String word){
        Trie root = this.head;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(root.children[c - 'a'] == null){
                root.children[c-'a'] = new Trie();
            }
            root = root.children[c-'a'];
        }
        root.isEnd = true;
    }

    public String longestWord(String[] words) {
        this.head = new Trie();

        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        //Calling DFS recursive function
        dfs(this.head, new StringBuilder());
        return result;
    }

    private void dfs(Trie node, StringBuilder sb){
        //base
        if(node.isEnd && sb.length() > result.length()){
            result = sb.toString();
        }

        //logic
        for(int i=0; i<26; i++){
            if(node.children[i] != null && node.children[i].isEnd){
                int length = sb.length();
                //Action
                sb.append((char)('a' + i));
                //Recurse
                dfs(node.children[i], sb);
                //Backtrack
                sb.setLength(length);
            }
        }
    }
}