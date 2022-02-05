// Time Complexity : O(n*l) l=> length of the word
// Space Complexity : O(n*l)
class Solution {
    class TrieNode{
        TrieNode [] children;
        boolean isEnd;
        String word;
        public TrieNode(){
            children=new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a']=new TrieNode();
            }
            curr=curr.children[ch-'a'];
        }
        curr.isEnd=true;
        curr.word=word;
    }
    public String longestWord(String[] words) {
        root=new TrieNode();
        for(String word:words){
            insert(word);
        }
        Queue<TrieNode> q=new LinkedList<>();
        q.add(root);
        TrieNode curr=null;
        while(!q.isEmpty()){
           curr =q.poll();
            for(int i=25;i>=0;i--){
                if(curr.children[i]!=null && curr.children[i].isEnd){
                    q.add(curr.children[i]);
                }
            }
        }
        if(curr.word==null)
            return "";
        return curr.word;
    }
}
