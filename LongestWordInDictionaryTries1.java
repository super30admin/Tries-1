class Solution {
   
    class TrieNode{
        String word;
        TrieNode[] children = new TrieNode[26];
    }
   
     TrieNode root;
    public void insert(String word) {  //inserted length in O(L) 'L' is length of the word
        TrieNode curr = root;
        for(int i = 0 ;i < word.length() ;i++){
            char c = word.charAt(i);
            //children in my current trie node that character is  not present then insert
            if(curr.children[c-'a'] == null ){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'] ; //move the pointer
        }
        curr.word = word; // after the entire word is finished the last node is set to true inorder not to allow partial word be true for example - get apple as true and app as not.
    }
   
    public String longestWord(String[] words) {
        root = new TrieNode();
        for( String s : words){
            insert(s);
        }
       
        Queue<TrieNode> q = new LinkedList();
        q.add(root);
        TrieNode curr = null;
        while(!q.isEmpty()){
            curr = q.poll();  // specify the word to start processing
            for(int i = 25; i >=0; i--){
                if(curr.children[i] != null  && curr.children[i].word != null){
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}

/*
Time complexity :O(nL) where n is no of words in dictionary and L is averaage length of each word
Space complexity:O(nL) for trie + O(n) for Queue where n is no of words with max length here 26 is the max length hence Queue = O(26) asymtotically O(1)
Space Complexity = O(nL) + O(1) = O(nL)
*/