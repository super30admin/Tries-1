//TC for prefix = O(n words*length of the word+ no.of words*avg length) =O(nl+mk)
//SC for Insert,search,prefix = O(n words * length of the word) = O(nl)

//Oracle
//It compares by extracting the substring for example cat and cattle if it present then check for the every character using trieNode root because it point to current and checks for child character if it present then check for last condition rat and if it present they every charcter key of hashmap is present in substring then return true else false .

//here constant 26 characters is ignored because it has multiple childs and multiple characters are repeating.Pick all the 3 words and goes into trie nod and split into strings.
class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
       root = new TrieNode();
        for(String word:dictionary){
            insert(word);
        }
        String[] splitStrings = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for(int i=0;i<splitStrings.length;i++){
            if(i!=0){
                result.append(" ");
            }
            String word = splitStrings[i];
            StringBuilder sb = new StringBuilder();
            TrieNode curr = root;
            for(int j=0;j<word.length();j++){
                char c = word.charAt(j);
                if(curr.children[c-'a'] == null || curr.isEnd){
                    break;
                }
                sb.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd){
                result.append(sb.toString());
            }
            else{
                result.append(word);
            }
        }
        return result.toString();
    }
}