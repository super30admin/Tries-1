/* 
Time Complexity : O(N*k + L); N=Total words in dictionary, k=Length of the longest word in the dictionary, L=Length of the sentence

Space Complexity :  O(N*k + L); N=Total words in dictionary, k=Length of the longest word in the dictionary, L=Length of the sentence

Did this code successfully run on Leetcode : Yes
*/


class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        //constructor
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    //method to insert the words of dictionary to the trie
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true; 
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || dictionary.size() == 0) return sentence;
        
        //trie building
        root = new TrieNode();
        for(String word: dictionary)
            insert(word);
        
        //splitting the sentence to form an array
        String[] splitArray = sentence.split("\\s");
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<splitArray.length; i++) {
            if(i != 0) result.append(" ");
            TrieNode curr = root;
            String word = splitArray[i];
            StringBuilder replacement = new StringBuilder();
            for(int j=0; j<word.length(); j++) {
                char c = word.charAt(j);
                if(curr.children[c-'a'] == null || curr.isEnd) break;
                curr = curr.children[c-'a'];
                replacement.append(c); 
            }
        if(curr.isEnd) result.append(replacement.toString());
        else result.append(word);
        }
        return result.toString();
    }
}