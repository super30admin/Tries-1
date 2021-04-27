//Time complexity: O(mn)
//Space Complexity: O(mn)
class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        String word;
        public TrieNode(){
            isEnd =false;
            children = new TrieNode[26];
        }
    }
    TrieNode root;  
    public void insert(String word){
        TrieNode curr= root;
        for(int i=0;i<word.length();i++){
            char c= word.charAt(i);
            if(curr.children[c-'a']==null){
                 curr.children[c-'a']= new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
        curr.word=word;
    }
    public String longestWord(String[] words) {
        root= new TrieNode();
        TrieNode curr =root;
        for(String word: words){
            insert(word);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            curr=q.poll();
            for(int i=25;i>=0;i--){
                if(curr.children[i]!=null && curr.children[i].word!=null){
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}