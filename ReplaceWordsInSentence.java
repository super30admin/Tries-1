/*TC :**

        If we have ‘n’ words in dictionary and ‘l’ is length of each word, to insert all of them in trie - O(nl)

        To find replacement of words - O(mk) ; m is no. of words in sentence and k is avg length of each word in sentence

        Total - O(nl) + O(mk) ; whichever is bigger in this will be dominating

        SC : O(nl) - space associated with trie
 */

import java.util.List;

public class ReplaceWordsInSentence {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    private void insert(String word){
        TrieNode curr = root;

        for(int i =0; i< word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();

        //build trie
        for(String word : dictionary){
            insert(word);
        }

        String[] splitArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i =0; i< splitArr.length; i++){

            //append space after each word except first word
            if(i!=0)
                result.append(" ");

            String word = splitArr[i];
            StringBuilder replacementWord = new StringBuilder();
            TrieNode curr = root;

            for(int j = 0; j < word.length(); j++){
                char c = word.charAt(j);

                if(curr.children[c-'a'] == null || curr.isEnd) break;
                curr = curr.children[c-'a'];
                replacementWord.append(c);
            }

            //check if we found replacement
            if(curr.isEnd){
                result.append(replacementWord);
            }else{
                result.append(word);
            }
        }
        return result.toString();
    }
}
