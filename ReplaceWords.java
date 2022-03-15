import java.util.ArrayList;
import java.util.List;
/*
Time Complexity: O(L), where L is the length of the given word
Space Complexity: O(1), constant as we created our own TrieNode class
Run on Leetcode: yes
Any difficulties: No

Approach:
1. Implementing Character tree Trie data structure using TrieNode class with children and isEnd as a variables
2. Using Trie class of the previous question for this implementation with an additional method getPrefixWord
2. Attempted after discussed in the class
 */
public class ReplaceWords {
    public static class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        TrieNode(){
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
    public static class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public String getPrefixWord(String word){
            TrieNode node = root;
            for(int i = 0; i<word.length(); i++){
                char c = word.charAt(i);
                if(node.children[c-'a'] == null){
                    return null;
                }
                node = node.children[c-'a'];
                if(node.isEnd){
                    return word.substring(0, i+1);
                }
            }
            return null;
        }

        public void insert(String word){
            TrieNode node = root;

            for(int i = 0; i<word.length(); i++){
                char c = word.charAt(i);

                if(node.children[c-'a'] == null){
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.isEnd = true;
        }

        public boolean prefix(String word){
            TrieNode node = root;

            for(int i = 0; i<word.length(); i++){
                char c = word.charAt(i);

                if(node.children[c-'a'] == null){
                    return false;
                }
                node = node.children[c-'a'];
            }
            return true;
        }

        public boolean search(String word){
            TrieNode node = root;

            for(int i =0; i<word.length(); i++){
                char c = word.charAt(i);

                if(node.children[c-'a'] == null){
                    return false;
                }
                node = node.children[c-'a'];
            }
            return node.isEnd;
        }
    }
    public static String replaceWords(List<String> dictionary, String sentence){
        Trie obj = new Trie();
        for(String root: dictionary){
            obj.insert(root);
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for(String word: words){
            if(result.length()>0){
                result.append(" ");
            }
            String prefixWord = obj.getPrefixWord(word);
            if(prefixWord!= null){
                result.append(prefixWord);
            }else{
                result.append(word);
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("rat");
        dictionary.add("bat");

        String sentence = "the cattle was rattled by the battery";

        System.out.println("Replacing root words: "+ replaceWords(dictionary,sentence));
    }
}
