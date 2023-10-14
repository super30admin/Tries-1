// Time Complexity : O(NL)+O(MK) where n is the length of dictionary l is the length of each string in dictionary, m is the length of sentence(in words) and k is the length of each word in sentence
// Space Complexity : O(NL)+O(MK) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem3 {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary.size() == 0 || dictionary == null){
            return sentence;
        }
        root = new TrieNode();

        for(String s : dictionary){
            insert(s);
        }
        String[] words = sentence.split("\s");
        StringBuilder result = new StringBuilder();


        for(int i = 0; i < words.length; i++){
            if(i != 0){
                result.append(" ");
            }
            StringBuilder replaceWord = new StringBuilder();
            String word = words[i];
            TrieNode curr = root;
            for(int j = 0; j < word.length(); j++){
                char c = word.charAt(j);
                if(curr.children[c - 'a'] == null || curr.isEnd){
                    break;
                }
                replaceWord.append(c);
                curr = curr.children[c - 'a'];
            }

            if(curr.isEnd){
                result.append(replaceWord);
            }else{
                result.append(word);
            }
        }

        return result.toString();
    }
}
