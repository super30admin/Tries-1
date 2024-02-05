class Solution {
    private  String ans = "";
    class TrieNode{
        String str;
        TrieNode [] children = new TrieNode[26];
        
    }
    public void insert(TrieNode root, String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.str = word;
    }
    private void dfs(TrieNode root){
        if(root == null) return;
        
        if(root.str != null ){
                if(root.str.length() > ans.length()) ans = root.str;
                else if (root.str.length() == ans.length() && root.str.compareTo(ans) < 0)
                    ans = root.str;
            }

        for(TrieNode child : root.children){
            if(child != null && child.str != null) dfs(child);
        }
    }
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for(String s : words){
            insert(root,s);
        }
        dfs(root);
        return ans;
    }
}