// Time Complexity : O(nk)
// Space Complexity : O(nk)

class Solution {
     class TreeNode{
        TreeNode[] children;
        String word;
        
        public TreeNode(){
            children = new TreeNode[26];
        }
    }
    TreeNode root;
    
    public void insert(String word){
        TreeNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new TreeNode();
            cur = cur.children[c - 'a'];
        }
        cur.word = word;
    }
    
    public String longestWord(String[] words) {
        root = new TreeNode();
        for(String word: words)
            insert(word);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode cur = root;
        while(!q.isEmpty()){
            cur = q.poll();
            for(int i = 25; i >= 0; i--){
                if(cur.children[i] != null && cur.children[i].word != null)
                    q.add(cur.children[i]);
            }
        }
        if(cur.word != null)
            return cur.word;
        
        return "";
    }
}