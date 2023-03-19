/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


class Solution {



    //Trie Approach
    //Time Complexity: O(n*l + m*l), n = length of sentence, m = number of words in dictionary, l = length of words
    //Space Complexity: O(m*l + n*l)
    class TrieNode {

        TrieNode[] children;
        boolean end;

        public TrieNode(){
            children = new TrieNode[26];
            end = false;
        }
    }

    class Trie {

        private TrieNode root;

        public Trie() {

            root = new TrieNode();
        }

        public void insert(String word) {

            TrieNode node = root;

            for(int i=0; i<word.length(); i++){

                int index = word.charAt(i) - 'a';
                if(node.children[index] == null){
                    node.children[index] = new TrieNode();

                }
                node = node.children[index];
            }
            node.end = true;
        }

        public String replace(String word){

            TrieNode node = root;
            String temp="";

            for(int i=0; i<word.length(); i++){

                int index = word.charAt(i) - 'a';

                if(node.end == true){
                    return temp;
                }

                if(node.children[index] == null){
                    return word;
                }
                temp += word.charAt(i);
                node = node.children[index];
            }
            return word;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        Trie obj = new Trie();

        for(String dict : dictionary){
            obj.insert(dict);
        }

        String[] words = sentence.split(" ");
        String result = "";
        for(String word: words){

            if(result != ""){
                result += " ";
            }
            result += obj.replace(word);

//             String temp = obj.replace(word);

//             if(temp!= null){
//                 result += temp;
//             }
//             else{
//                 result += word;
//             }
        }
        return result;
    }




    //HashSet Approach
    //Time Complexity: O(n*k*k), n = number of words in sentence, k = average length of words in sentence
    //Space Complexity: O(m), m = number of words in dictionary

//     public String replaceWords(List<String> dictionary, String sentence) {

//         Set<String> set = new HashSet<>(dictionary);

//         StringBuilder result = new StringBuilder();
//         String[] strArr = sentence.split(" ");

//         for(int i=0; i<strArr.length; i++){

//             String word = strArr[i];

//             if(i>0) result.append(" ");

//             int prevLen = result.length();

//             for(int j=0; j<word.length(); j++){

//                 String currWord = word.substring(0, j+1);

//                 if(set.contains(currWord)){
//                     result.append(currWord);
//                     break;
//                 }
//             }

//             if(prevLen == result.length()){
//                 result.append(word);
//             }
//         }
//         return result.toString();
//     }
}

public class ReplaceWordsLC648 {
}
