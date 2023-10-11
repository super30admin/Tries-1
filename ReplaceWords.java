import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create a list of root words (dictionary)
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");

        // Input sentence
        String sentence = "the cattle was rattled by the battery";

        // Call the replaceWords method to perform word replacement
        String replacedSentence = solution.replaceWords(dictionary, sentence);

        // Print the replaced sentence
        System.out.println("Replaced Sentence: " + replacedSentence);
    }
}
//TC - O(nl) + O(mk)
//SC - O(nl) + O(mk)

class Solution {

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            isEnd = false; //don't need to initialize by default it is set to false'
            children = new TrieNode[26];
        }
    }
    TrieNode root;

    //TC - n words and l average length of 1 word O(nl)
    //SC - O(nl)
    public void insert(String word){
        TrieNode curr = root;

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);

            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    //TC - m words, k average length of each word O(mk)
    //SC - O(ml)
    public String replaceWords(List<String> dictionary, String sentence) {

        if(dictionary == null || dictionary.size() == 0){
            return sentence;
        }

        root = new TrieNode();

        //create a tree of words in dictionary
        for(String word: dictionary){
            insert(word);
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for(int i=0; i<words.length; i++){
            if(i!= 0){
                result.append(" ");
            }
            String word = words[i];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;

            for(int j=0; j<word.length(); j++){
                char c = word.charAt(j);
                if(curr.children[c - 'a'] == null || curr.isEnd){
                    break;
                }
                replacement.append(c);
                curr = curr.children[c - 'a'];
            }
            if(curr.isEnd){
                result.append(replacement);
            }else{
                result.append(word);
            }
        }

        return result.toString();
        
    }
}