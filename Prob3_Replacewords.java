// n - words in disctionary, k = Avg. Length of words in disctionary, m - words in a sentence, l = Avg. length of words in sentence

// Time Complexity : O(N*K + M*L)
// Space Complexity : O(N*K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public void insert(String word) {
        TrieNode curr = root; // Taken root as current to traverse ther Trie
        for(int c = 0; c< word.length(); c++){
            char ch = word.charAt(c);
            if(curr.children[ch - 'a'] == null){ //Checking if curr's children having character ch or not
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true; // Making isEnd to true to check word ended here or not for future
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        
        for(String p : dictionary){ // INserting words from Dictionary to Trie
            insert(p);
        }
        
        String[] strArr = sentence.split(" "); //Array of words 
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < strArr.length; i++){
            
            TrieNode curr = root;
            StringBuilder temp = new StringBuilder(); // For replacement of String
            String s = strArr[i];
            
            if(i > 0)   str.append(" ");
            for(int k = 0; k< s.length(); k++){
                char ch = s.charAt(k);
                if(curr.isEnd || curr.children[ch - 'a'] == null) break; // If the char is not matching, break the current iteration
                curr = curr.children[ch - 'a'];
                
                temp.append(ch);
            }
            
            if(curr.isEnd){ //After finding each replacement, append the tempString into resultant string
                str.append(temp);
            }else{
                str.append(s); //Word itself
            }
            
           // str.append(" ");
        
        }
        return str.toString();
    }
}