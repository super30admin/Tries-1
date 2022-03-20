// Time Complexity : O(n * m) n - no of words, m - word size; Insertion and Comparisions should be constant dictionary length O(n * m).
// Space Complexity : O(n * m * Total_Char_Size) n - no of words, m - word size, ALphabets_Size = 26. If ascii also included then 255.
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/663633376/)
// Any problem you faced while coding this : No.
// My Notes : Comparisions can be optimized using DFS and BFS.
class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    Character nextChar;
    TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }
}

class Solution {
    TrieNode trieRoot = null;
    public String longestWord(String[] words) {
        trieRoot = new TrieNode();
        String longWord = "";
        // Insert initially words and make links
        for (String word : words){
            insert(word);
        }
        for (String word : words){
            String retWord = insertOld(word);
            // prints the return value of the comparison
            if(retWord.length() > longWord.length()){
                longWord = retWord;
            }else{
                if(retWord.length() == longWord.length()){
                    if (retWord.compareTo(longWord) < 0) {
                        longWord = retWord;
                    } 
                }
            }
            //System.out.println(" Current long is "+longWord);
        }
        return longWord;
    }

    private void insert(String word){
        TrieNode node = trieRoot;
        for(int i =0;i< word.length();i++){
            char c = word.charAt(i);
            if(node.children[c-'a'] == null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isEnd = true;
    }

    private String insertOld(String word){
        StringBuilder sb = new StringBuilder();
        TrieNode node = trieRoot;
        for(int i =0;i< word.length();i++){
            char c = word.charAt(i);            
            if(node.children[c-'a'].isEnd){
                sb.append(c);
                //System.out.println("Checking sb formation : "+sb.toString());
                node = node.children[c-'a'];
            }else{
                return "";
            }
        }
        //System.out.println();
        return sb.toString();
    }
}