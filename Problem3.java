// Time Complexity : O(mL +nL)= O(nL) = O(n)
//      m: length of dictionary
//      L: length of word in dictionary
//      n: number of words in sentence
// Space Complexity : O(mL + n) = O(n)
//      m: length of dictionary
//      L: length of word in dictionary
//      n: number of words in sentence
//   Here dictionary length at most 1000
//   And also length of each word in dictionary is at most 100
// Note: Even for all the words in sentence, we iterate only L characters of dictionary
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.List;

// Your code here along with comments explaining your approach
class Problem3 {
    /** Class Definition */
    class TrieNode{
        
        // members
        boolean isEnd;
        TrieNode[] children;
        
        TrieNode(){
            // for a-z
            children = new TrieNode[26];
        }
    }
    
    // global
    TrieNode root;
    
    /** Inserts a word into the trie. */
    public void insert(String word) {

        // initialize
        TrieNode current = root;

        // insert all the characters
        for(int i=0; i<word.length(); i++){

            // Mapping index: [a-z] -> [0-25]
            int index = word.charAt(i) - 'a';

            // not null
            if(current.children[index] == null)
                current.children[index] =  new TrieNode();
            // update current
            current = current.children[index];
        }
        // end of the word
        current.isEnd = true;
    }
    
    /** Replace words of sentence*/
    public String replaceWords(List<String> dict, String sentence) {
        
        // edge case
        if(dict == null || dict.size()==0 || sentence == null)
            return sentence;
        
        // initialize root
        root = new TrieNode();

        // build Trie
        for(String word: dict)
            insert(word);
        
        // Split on space
        String[] sentenceList = sentence.split("\\s+"); // has multiple space
        StringBuilder result = new StringBuilder();
        
        // iterate all the words of the sentence
        for(String word: sentenceList){

            // check for replacement
            TrieNode current = root;
            int i = 0;
            // character by character
            while(i< word.length()){

                // Mappping index: [a-z] -> [0-25]
                int index = word.charAt(i)-'a';

                // next character not  present OR end of the word
                if(current.children[index] == null || current.isEnd)
                    break;
                // next character present
                current = current.children[index];
                i++;
            }

            // replacement found
            if(current.isEnd)
                // entire substring
                result.append(word.substring(0, i) +" ");// adding space
            // not found
            else
                result.append(word +" ");
        }
        // remove space from the end
        return result.toString().trim();
    }
}