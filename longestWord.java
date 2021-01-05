// Time Complexity : O(max length of string)
// Space Complexity : O(No of strings)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        String word = "";
    }
    
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        
        for(String word : words) {
            
            TrieNode curr = root;            
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TrieNode();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.isEnd = true;
            curr.word = word;
        }
        
        Queue<TrieNode> queue = new LinkedList();
        
        TrieNode curr = root;
        String res = "";
        
        for(int i = 25; i >= 0; i--) {
            if(curr.children[i] != null){
                queue.add(curr.children[i]);
                // System.out.println(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TrieNode temp = queue.poll();
                if(!temp.word.equals("")){
                    res = temp.word;
                    // System.out.println(res);
                    for(int i = 25; i >=0; i--){
                        if(temp.children[i] != null){
                            queue.add(temp.children[i]);
                        }
                    }
                }
            }
        }
        
        return res;
        
        
    }
}
