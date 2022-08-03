//TC:O(nl) = O(n word * avg length of word)
//SC:max(nl)
//De shaw
//checking root and add into queue by checking the queue from right to left.Not given any word simply return a empty string ex:" ".Going in low lexico graphical order and size distinct action when my level change & don't demarcation between level.
class Solution {
    class TrieNode{
        TrieNode[] children;
        String word;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }
    public String longestWord(String[] words) {
        root = new TrieNode();
        if(words == null || words.length == 0) return "";
        
        for(String word:words){
            insert(word);
        }
        //Start your bfs
        Queue<TrieNode> q = new LinkedList<>();
        TrieNode curr = root;
        q.add(root);
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i=25;i>=0;i--){
                if(curr.children[i] != null && curr.children[i].word!=null){
                    q.add(curr.children[i]);
                }
            }
        }
        if(curr.word == null) return "";
        return curr.word;
    }
}