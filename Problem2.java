//Time Complexity : O(n)
//Space Complexity:O(n)

class Solution {
    class TrieNode{
    TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    public String longestWord(String[] words) {
        if(words==null || words.length==0)return "";
        TrieNode root = new TrieNode();
        for(String word:words){
            insert(root,word);
        }
        Queue<TrieNode> q = new LinkedList<>();
        Queue<String> sq = new LinkedList<>();
        TrieNode curr = root;
        String currSt = "";
        q.add(curr); sq.add(currSt);
        while(!q.isEmpty()){
            curr = q.poll();
            currSt = sq.poll();
            for(int i =25; i>=0;i--){
                if(curr.children[i]!=null && curr.children[i].isEnd){
                    q.add(curr.children[i]);
                    String newStr = currSt + (char)(i+97);
                    sq.add(newStr);
                }
            }
        }
        return currSt;
    }
    private void insert(TrieNode root, String word){
        TrieNode curr = root;
        for(int i =0; i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
}
