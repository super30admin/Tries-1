// Time Complexity : O(n) n is  the total number of characters in all words
// Space Complexity : O(n) n is  the total number of characters in all words
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class LongestWord {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
        String word;
    }
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                if(node.children[c-'a'] == null) node.children[c-'a'] = new TrieNode();
                node = node.children[c-'a'];
            }
            node.word  = word;
            node.isWord = true;
        }
        
        
        String ans = "";
        Queue<TrieNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TrieNode node = q.poll();
                boolean flag= false;
                for(TrieNode n : node.children){
                    if(n != null && n.isWord){
                        if(ans.length() < n.word.length() || ans.compareTo(n.word) > 0) ans = n.word;
                        q.offer(n);
                    }
                }
            }
        }
        
        return ans;
        
        
    }
}