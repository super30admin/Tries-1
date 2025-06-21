// Time Complexity -> O(n * l) here n is length if input array and l is the length of longest word
// Space Complexiy -> O(l * chars in it)
class Solution {
    TrieNode root;
    private class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public  TrieNode(){
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }

    private void Insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    String longest = "";

    public String longestWord(String[] words) {
        root = new TrieNode();
        root.isEnd = true;
        for(String word : words){
            Insert(word);
        }

        String curr = "";
        dfs(curr, root);
        return longest;
    }

    public void dfs(String curr, TrieNode root){
        if(root == null || !root.isEnd) return;

        if(curr.length() > longest.length()) longest = curr;
        for(int i = 0; i < 26; i++){
            //action
            String newCurr = curr + String.valueOf((char)(i+97));
            // recurse
            dfs(newCurr, root.children[i]);
        }
    }
}
