// Time Complexity : O(mxn) m is length of input array , n is longest word of the input array
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class LongestWord {
    class TrieNode{
        TrieNode[] children;
        char c;
        boolean isWord;
        boolean isValid;
        TrieNode(char c){
            this.c=c;
            children = new TrieNode[26];
            isWord=false;
            isValid=false;
        }
    }
    
    public String longestWord(String[] words) {
        Arrays.sort(words);
        TrieNode root = new TrieNode('-');
        root.isValid=true;
        String ans = "";
        for(String word:words){
            if(insert(root,word)){
                if(word.length()>ans.length())
                    ans=word;
            }
        }
        return ans;
    }
    
    private boolean insert(TrieNode root,String word){
        TrieNode prev = root;
        TrieNode curr = root;
        int newChar=0;
        for(int i=0;i<word.length();i++){
            if(curr.children[word.charAt(i)-'a']!=null){
                prev=curr;
                curr=curr.children[word.charAt(i)-'a'];
                
            }
            else{
                newChar++;
                prev=curr;
                curr.children[word.charAt(i)-'a'] = new TrieNode(word.charAt(i));
                curr=curr.children[word.charAt(i)-'a'];
            }
            
            
        }
        
         curr.isWord=true;
            if(newChar==1){
                if(prev.isValid)
                {
                    curr.isValid=true;
                return true;}
                
            }
            //return false;
        return false;
    }
    
}