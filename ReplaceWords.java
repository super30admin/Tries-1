//Time Complexity:O(n)
//Space Complexity:O(n)


import java.util.List;

class Solution {
    class TrieNode{
        TrieNode child[];
        boolean isEnd;

        public TrieNode(){
            child = new TrieNode[26];
        }
    }

    TrieNode root;
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.child[c-'a'] == null){
                curr.child[c-'a'] = new TrieNode();
            }
            curr = curr.child[c-'a'];
        }
        curr.isEnd = true;

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String s:dictionary){
            insert(s);
        }

        String[] strr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i=0;i<strr.length;i++){

            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            String word = strr[i];
            if(i>0){
                result.append(" ");
            }
            for(int j=0 ;j< word.length();j++){

                char c = word.charAt(j);
                if(curr.child[c-'a'] == null || curr.isEnd){
                    break;
                }
                replacement.append(c);
                curr=curr.child[c-'a'];
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