
//TC is O(mxk) + O(nxl)
//sc is O(nxl) from the construction of trie (n words and each word has an average length of l) +
//O(mxk) for the splitting of the string and the string builder is O(mxk) which is length of sentence
//so total sc is O(mxk) + O(nxl)
import java.util.*;

class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26]; // because lowercase

        }
    }

    TrieNode root;

    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || dictionary.size() == 0) return sentence;

        
        //we put all words from dictionary in TrieNode
        root = new TrieNode();
        //number of words in dictionary is n and l is the length of each word so tc for
        //this method is O(nxl)
        for(String word: dictionary){
            insert(word);
        }

        //tc to split string -> if there are m words in sentence and k is the average length of each word
        //tc is O(mxk)
        String[] strArray = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        //tc for next function is also O(mxk) as we are
        //going over all m words
         k times
        for(int i=0; i<strArray.length; i++){
        
            if(i!=0) result.append(" ");
            String word = strArray[i];
            TrieNode curr = root;
            StringBuilder newWord = new StringBuilder();

            for(int j=0; j < word.length(); j++){
                char ch = word.charAt(j);

                if(curr.children[ch - 'a'] == null || curr.isEnd){
                    break;
                }

                newWord.append(ch);
                curr = curr.children[ch-'a'];
            }

             if(curr.isEnd){
                
                result.append(newWord);

            }
            else{
                System.out.println("here");
                result.append(word);

            }

        }

        return result.toString();

        
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }

            curr = curr.children[ch - 'a'];

        }

        curr.isEnd = true;
    }

}