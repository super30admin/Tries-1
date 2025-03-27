//Time Complexity : O(l), l=length of input word
//Space Complexity : O(n)  , n=total length of all the words
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Trie {
    class TrieNode{
        TrieNode[] tn=new TrieNode[26];
        boolean isEnd;
    }
    private TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.tn[ch-'a']==null){
                curr.tn[ch-'a']=new TrieNode();
            }
            curr=curr.tn[ch-'a'];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.tn[ch-'a']==null){
                return false;
            }
            curr=curr=curr.tn[ch-'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            if(curr.tn[ch-'a']==null){
                return false;
            }
            curr=curr=curr.tn[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
