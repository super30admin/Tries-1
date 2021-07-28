//Time Complexity : O(M*N) + O(K*L). To build the trie : O(M*N), to check and replace the words in sentence : O(K*L)
//Space Complexity : O(M*N) which is occupied by trie
class Solution {
    //using trie data structure to determine the prefix words
    class TrieNode{
        boolean isEnd;
        TrieNode children[];
        public TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    //insert the words in dictionary to tire
    void insert(String word){
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary==null || dictionary.size()==0){
            return sentence;
        }
        root = new TrieNode();//initialize the root
        //insert the dictionary into trie
        for(String w : dictionary){
            insert(w);
        }
        StringBuilder result = new StringBuilder();
        StringBuilder replace;
       //convert the sentence into string array and remove the spaces
        String[] sent = sentence.split("\\s+");
        //iterate through the sentence
        for(int i=0;i<sent.length;i++){
            //append space after each word
            if(i>0){
                result.append(' ');
            }
            TrieNode cur = root;
            String word = sent[i];
            replace = new StringBuilder();
            //iterate through each char in the word and search if its present in the trie
            for(int j=0;j<word.length();j++){
                char c = word.charAt(j);
                //word is not found in trie as well as in dict
                if(cur.children[c-'a']==null || cur.isEnd){
                    break;
                }
                replace.append(c);
                cur = cur.children[c-'a'];
            }
            //if found add it to the result
            if(cur.isEnd){
                result.append(replace.toString());
            }
            else{
                result.append(word);
            }
        }
        return result.toString();
    }
}