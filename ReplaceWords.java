
 //Time Complexity: O(N*M) + O(K*L) Where N is the number of words in dict and M is the average length of words, K is the number of words in the sentence and L is the average length of the word.
 //Space Complexity: O(N*M) Where N is the number of words in dict and M is the average length of words.

// We can solve this problem using Trie datastructure. 


class Solution {

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.isEnd = isEnd;
            this.children = new TrieNode[26];
        }
    }
    private TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String str: dictionary){
            insert(str);
        }
        StringBuilder result = new StringBuilder();
        for(String str: sentence.split(" ")){
            String prefix = prefix(str);
            if(prefix!=null){
                result.append(prefix);
            }else{
                result.append(str);
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

    private void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr=curr.children[ch-'a'];
        }
        curr.isEnd=true;
    }

    private String prefix(String word){
        TrieNode curr = root;
        String result=null;
        StringBuilder prefix=new StringBuilder();

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.isEnd){
                return prefix.toString();
            }
            if(curr.children[ch-'a']==null){
                return null;
            }
            prefix.append(ch);
            curr=curr.children[ch-'a'];
        }
        return result;
    }
}