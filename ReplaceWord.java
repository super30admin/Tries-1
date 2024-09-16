class Solution {

    //Time Complexity : 0(nK) + 0(ml) where n:length of the word, K:avg length of the sentence;  m : length of the word in the sentence,  l : avg length of the sentence
    //Space Complexity: 0(nK) + 0(ml)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In brief explain your approach

    class TrieNode{
        TrieNode[] child;
        boolean isEnd;
        public TrieNode(){
            child = new TrieNode[26];
        }
    }
    TrieNode root;

    public void insert(String word){
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(current.child[c - 'a'] == null){
                current.child[c - 'a'] = new TrieNode();
            }
            current = current.child[c - 'a'];
        }
        current.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        StringBuilder result = new StringBuilder();
        for(String dic : dictionary){
            insert(dic);
        }
        String [] split = sentence.split(" ");
        for(int i = 0; i < split.length; i++){
            String word = split[i];
            StringBuilder newString = new StringBuilder();
            TrieNode current = root;
            for(int j = 0; j < word.length(); j++){
                char c = word.charAt(j);
                if(current.child[c - 'a'] == null || current.isEnd){
                    break;
                }
                newString.append(c);
                current = current.child[c - 'a'];
            }
            if(current.isEnd){
                result.append(newString);
            }
            else{
                result.append(word);
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}