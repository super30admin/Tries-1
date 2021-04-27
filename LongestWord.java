    /*
     *  Time Complexity: O(N*M) Where N is the number of words and M is the average length of words.
     *  Space Complexity: O(N*M) Where N is the number of words and M is the average length of words.
     *
     *  Did this code successfully run on Leetcode : Yes
     *  Any problem you faced while coding this : None
     *
     *  Explanation: We can solve this problem using Trie datastructure. With all the given words we create a trie datasturcture, which consists of an array of length 26 representing all the lower case alaphabets and a String word. If a trie node is the last character of the word, we populate the string TrieNode.word with that actual word. Now we create a queue and place the root node into it. We the traverse through the queue until its empty, every time we poll the top node and then traverse through all the children and check if its not null and child.word is not null, it its staisfied the requirements we add that to the queue. The last node in the queue would hold the answer.
     */

class Solution {
    class TrieNode{
        String word;
        TrieNode children[];
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    
    private void insert(String word){
        if(word==null || word.length()==0) return;
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a']=new TrieNode();
            }
            curr=curr.children[ch-'a'];
        }
        curr.word=word;
    }
    
    public String longestWord(String[] words) {
        if(words==null || words.length==0) return null;
        
        root=new TrieNode();
        for(String word: words){
            insert(word);
        }
        
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        TrieNode curr=null;
        while(!queue.isEmpty()){
            curr = queue.poll();
            for(int i=curr.children.length-1;i>=0;i--){
                if(curr.children[i]!=null && curr.children[i].word!=null){
                    queue.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}
