/*Running Time Complexity:O(nlogk)
Space Complexity: O(n)
Successfully Run and Compiled on leetcode
*/
class Solution {
    class TrieNode{
        TrieNode[] children;
        String word;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    TrieNode root;
    public String longestWord(String[] words) {
        if(words==null) return "";
        root = new TrieNode();
        for(String word : words){
            insert(word);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr=null;
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25;i>=0;i--){
                if(curr.children[i]!=null && curr.children[i].word != null){
                    q.add(curr.children[i]);
                }
            }
        }
       if(curr.word==null)return ""; 
       return curr.word; 
    }
    private void insert(String words){
        
        TrieNode curr = root;
        for(int i =0;i<words.length();i++){
            char c = words.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = words;
        
    }
}